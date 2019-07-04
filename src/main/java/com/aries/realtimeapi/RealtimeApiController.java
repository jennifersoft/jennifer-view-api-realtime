package com.aries.realtimeapi;

import aries.core.OTypeDef;
import aries.def.MxDef;
import aries.lang.DOUBLES;
import aries.lang.NUMBERA;
import aries.lang.TLIST;
import com.aries.data.db.StoreKey;
import com.aries.extension.starter.PluginController;
import com.aries.realtimeapi.model.RealtimeDomainData;
import com.aries.realtimeapi.model.RealtimeDomainDataSet;
import com.aries.view.core.nio.DataServerException;
import com.aries.view.domain.Agent;
import com.aries.view.domain.DataServer;
import com.aries.view.service.DomainService;
import com.aries.view.service.mng.AgentService;
import com.aries.view.service.perf.ActiveServiceService;
import com.aries.view.service.perf.DBSearchService;
import com.aries.view.service.perf.RealtimeDataService;
import com.aries.view.service.perf.StandardDataService;
import com.aries.view.util.CalendarIgnoreDaylightSavingTime;
import com.aries.view.util.MetricsDataConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RealtimeApiController extends PluginController {
    @Autowired
    private DomainService domainService;
    @Autowired
    private StandardDataService standardDataService;
    @Autowired
    private ActiveServiceService activeService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private RealtimeDataService realtimeDataService;
    @Autowired
    private DBSearchService dbSearchService;


    @RequestMapping(value = { "/realtimeapi" }, method = RequestMethod.GET)
    public String mainPage()
    {
        return "realtimeapi";
    }

    @RequestMapping(value = { "/realtimeapi/domain" }, method = RequestMethod.GET)
    @ResponseBody
    public RealtimeDomainDataSet realtimeDomain(@RequestParam(name = "domain_id", defaultValue = "0") short domainId) throws DataServerException
    {
        return getRealtimeDomainData(domainId);
    }

    private RealtimeDomainDataSet getRealtimeDomainData(short domainId) throws DataServerException
    {
        RealtimeDomainDataSet result = new RealtimeDomainDataSet();
        List<RealtimeDomainData> list = new ArrayList<RealtimeDomainData>();

        if (domainId > 0)
        {
            DataServer ds = domainService.get(domainId);
            RealtimeDomainData data = processRealtimeDomainData(ds, domainId);

            list.add(data);
        }
        else
        {
            DataServer[] domains = domainService.list();
            for (DataServer ds : domains)
            {
                RealtimeDomainData data = processRealtimeDomainData(ds, ds.getSid());

                list.add(data);
            }
        }

        result.setList(list);

        return result;
    }

    private RealtimeDomainData processRealtimeDomainData(DataServer dataServer, short sid) throws DataServerException
    {
        Vector<StoreKey> storeKeys = new Vector<StoreKey>();
        storeKeys.add(new StoreKey(OTypeDef.SYSTEM, MxDef.agent_service_rate, 0));
        storeKeys.add(new StoreKey(OTypeDef.SYSTEM, MxDef.agent_service_time, 0));
        storeKeys.add(new StoreKey(OTypeDef.SYSTEM, MxDef.concurrent_user, 0));
        storeKeys.add(new StoreKey(OTypeDef.SYSTEM, MxDef.agent_reject_rate, 0));

        TLIST listValue = realtimeDataService.getLast(sid, storeKeys);

        RealtimeDomainData realtimeDomainData = new RealtimeDomainData();
        realtimeDomainData.setDomainId(sid);
        realtimeDomainData.setDomainName(dataServer.getShortName());
        realtimeDomainData.setIpAddress(dataServer.getIp());
        realtimeDomainData.setPort(dataServer.getPort());
        realtimeDomainData.setTps(listValue.get(0).getNumberValue());
        realtimeDomainData.setResponseTime(listValue.get(1).getNumberValue());
        realtimeDomainData.setConcurrentUser(listValue.get(2).getNumberValue());
        realtimeDomainData.setRejectRate(listValue.get(3).getNumberValue());

        List<Agent> instanceList = agentService.getOnlyAgentList(sid);

        Map<Integer, int[]> activeServiceCountMap = MetricsDataConvertor.getActiveService(sid,
                getOids(instanceList, sid),
                activeService.getActiveService(
                        sid,
                        false,
                        false),
                activeService.getRange());

        setActiveServiceWithRange(realtimeDomainData, activeServiceCountMap.get(0));

        NUMBERA hitHourNumbera = standardDataService.getData24H(sid,
                new StoreKey(OTypeDef.SYSTEM, MxDef.service_count, 0),
                "");
        NUMBERA visitHourNumbera = standardDataService.getData24H(sid,
                new StoreKey(OTypeDef.SYSTEM, MxDef.visit_hour, 0),
                "");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        int hour = CalendarIgnoreDaylightSavingTime.getHour(c.getTimeInMillis());

        realtimeDomainData.setHitHour(hitHourNumbera.intValue(hour));
        realtimeDomainData.setVisitHour(visitHourNumbera.intValue(hour));

        long todayStime = CalendarIgnoreDaylightSavingTime.getTodayStartTime(), todayEtime = todayStime + CalendarIgnoreDaylightSavingTime.ONE_DAY;

        //그냥 .get()을 호출하였음. OpenAPI는 일단 동기화되어서 데이터를 내보낸다.
        TLIST hitDayTLIST = dbSearchService.findMetricsData(sid,
                todayStime,
                todayEtime,
                24 * 60,
                OTypeDef.SYSTEM,
                new int[] { 0 },
                MxDef.service_count).get();
        TLIST visitDayTLIST = dbSearchService.findMetricsData(sid,
                todayStime,
                todayEtime,
                24 * 60,
                OTypeDef.SYSTEM,
                new int[] { 0 },
                MxDef.visit_day).get();


        DOUBLES hitDayValue = (DOUBLES) ((TLIST) ((TLIST) hitDayTLIST.get(0)).get(0)).get(0);
        DOUBLES visitDayValue = (DOUBLES) ((TLIST) ((TLIST) visitDayTLIST.get(0)).get(0)).get(0);

        realtimeDomainData.setHitDay((int) hitDayValue.get(0));
        realtimeDomainData.setVisitDay((int) visitDayValue.get(0));

        return realtimeDomainData;
    }

    private int[] getOids(List<Agent> instanceList, short sid)
    {
        int[] oids = new int[instanceList.size()];
        for (int i = 0, max = oids.length; i < max; i++)
        {
            oids[i] = instanceList.get(i).getOid();
        }

        return oids;
    }

    private void setActiveServiceWithRange(RealtimeDomainData realtimeDomainData, int[] activeServiceCountByRange)
    {
        int totalActiveServiceCount = activeServiceCountByRange[0] + activeServiceCountByRange[1] + activeServiceCountByRange[2] + activeServiceCountByRange[3];

        realtimeDomainData.setActiveService(totalActiveServiceCount);
        realtimeDomainData.setActiveServiceRandgeCount0(activeServiceCountByRange[0]);
        realtimeDomainData.setActiveServiceRandgeCount1(activeServiceCountByRange[1]);
        realtimeDomainData.setActiveServiceRandgeCount2(activeServiceCountByRange[2]);
        realtimeDomainData.setActiveServiceRandgeCount3(activeServiceCountByRange[3]);
    }
}