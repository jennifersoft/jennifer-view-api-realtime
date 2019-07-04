package com.aries.realtimeapi;

import aries.lang.*;
import com.aries.data.db.StoreKey;
import com.aries.data.lang.profile.PiData;
import com.aries.data.record.RealtimeMetricsRecord;
import com.aries.data.viewdata.CpuUsageViewData;
import com.aries.data.viewdata.TimeAndValue;
import com.aries.data.viewdata.TransactionViewData;
import com.aries.extension.starter.PluginStarter;
import com.aries.view.core.nio.DataServerException;
import com.aries.view.dao.file.RealTimeXViewConfigDao;
import com.aries.view.domain.Agent;
import com.aries.view.domain.DataServer;
import com.aries.view.ql.MetricsCollection;
import com.aries.view.service.DomainService;
import com.aries.view.service.ViewDataResponseFuture;
import com.aries.view.service.mng.AgentService;
import com.aries.view.service.perf.*;
import com.aries.view.wrapper.PiDataFormat;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.*;

@SpringBootApplication
public class    RealtimeApiApplication extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PluginStarter()).addPathPatterns("/plugin/**");
    }

    @Bean
    public DomainService getDomainService() {
        return new DomainService() {
            @Override
            public DataServer get(short i) {
                return null;
            }

            @Override
            public DataServer[] list() {
                return new DataServer[0];
            }

            @Override
            public DataServer[] listCacheLimit() {
                return new DataServer[0];
            }

            @Override
            public DataServer[] accessibleList(String s) throws JSONException {
                return new DataServer[0];
            }

            @Override
            public DataServer[] connectedList() {
                return new DataServer[0];
            }

            @Override
            public DataServer getDefaultOrNull() {
                return null;
            }

            @Override
            public Map<Short, Boolean> statusList() {
                return null;
            }

            @Override
            public Map<Short, DataServer> toMap() {
                return null;
            }

            @Override
            public short getDefaultSid() {
                return 0;
            }

            @Override
            public boolean isValid(short i) {
                return false;
            }

            @Override
            public boolean saveDomain(DataServer dataServer) {
                return false;
            }

            @Override
            public boolean updateDomain(DataServer dataServer) {
                return false;
            }

            @Override
            public boolean updateCacheLimit(RealTimeXViewConfigDao.XViewConfig xViewConfig) {
                return false;
            }

            @Override
            public boolean removeDomain(short i) {
                return false;
            }

            @Override
            public RealTimeXViewConfigDao.XViewConfig getMinTimeForDomain(short i) {
                return null;
            }

            @Override
            public Map<String, Object> getInstanceManagePolicy(short i) throws DataServerException {
                return null;
            }

            @Override
            public boolean setInstanceManagePolicy(short i, boolean b, int i1, boolean b1, boolean b2, byte b3, byte b4, int i2) throws DataServerException {
                return false;
            }

            @Override
            public boolean setInstanceNamingRule(short i, byte b, boolean b1) throws DataServerException {
                return false;
            }

            @Override
            public boolean setInstanceOrders(short i, int[] ints, short[] shorts) {
                return false;
            }

            @Override
            public Map<Integer, Short> getInstanceOrders(short i) {
                return null;
            }

            @Override
            public Map<String, Boolean> getSqlParameterCollection(short i) throws DataServerException {
                return null;
            }

            @Override
            public boolean setSqlParameterCollection(short i, boolean b, boolean b1) throws DataServerException {
                return false;
            }

            @Override
            public boolean setDomainGroups(String[] strings, short[] shorts, String[] strings1) {
                return false;
            }

            @Override
            public List<Map<String, Object>> getDomainGroups() {
                return null;
            }

            @Override
            public boolean isDomainGroupUsage() {
                return false;
            }

            @Override
            public void setDomainGroupUsage(boolean b) {

            }

            @Override
            public List<Map<String, Object>> getDomainGroupsWithUncategory(short[] shorts) {
                return null;
            }

            @Override
            public List<Map<String, Object>> getUnknownDomainGroups(short[] shorts) {
                return null;
            }
        };
    }

    @Bean
    public AgentService getAgentService() {
        return new AgentService() {
            @Override
            public boolean isPendingAgentOptions(short i, int i1) throws DataServerException {
                return false;
            }

            @Override
            public boolean applyPendingAgentOptions(short i, int i1) throws DataServerException {
                return false;
            }

            @Override
            public TABLE getSessionList(short i) throws DataServerException {
                return null;
            }

            @Override
            public TABLE getAllList(short i) throws DataServerException {
                return null;
            }

            @Override
            public TABLE getAllInstanceList(short i) throws DataServerException {
                return null;
            }

            @Override
            public TABLE[] getAllInstanceList(short[] shorts) throws DataServerException {
                return new TABLE[0];
            }

            @Override
            public List<Agent> findHost(short i) throws DataServerException {
                return null;
            }

            @Override
            public List<Agent> getOnlyAgentList(short i) throws DataServerException {
                return null;
            }

            @Override
            public List<Agent> getOnlyAgentList(short i, List<Integer> list) throws DataServerException {
                return null;
            }

            @Override
            public List<Agent> getOnlyHostList(short i, List<Integer> list) throws DataServerException {
                return null;
            }

            @Override
            public ViewDataResponseFuture<TABLE> getWorkList(short i) throws DataServerException {
                return null;
            }

            @Override
            public TABLE[] getWorkList(short[] shorts) throws DataServerException {
                return new TABLE[0];
            }

            @Override
            public boolean modifyName(short i, int i1, String s, String s1) throws DataServerException {
                return false;
            }

            @Override
            public List<Agent> findPeriodAgentList(short i, long l, long l1, List<Integer> list) throws DataServerException {
                return null;
            }

            @Override
            public List<Agent> findPeriodHostList(short i, String s, String s1, List<Integer> list) throws DataServerException {
                return null;
            }

            @Override
            public Map<Integer, String> getShortNames(short i, INTS ints) throws DataServerException {
                return null;
            }

            @Override
            public boolean remove(short i, int i1) throws DataServerException {
                return false;
            }

            @Override
            public List<Map<String, Object>> getAgentUpgradeList(short i) throws DataServerException {
                return null;
            }

            @Override
            public byte setAgentUpgrade(short i, int i1, String s, byte[] bytes) throws DataServerException {
                return 0;
            }

            @Override
            public List<Agent> findAgent(short i) throws DataServerException {
                return null;
            }

            @Override
            public Agent findAgent(short i, int i1) throws DataServerException {
                return null;
            }

            @Override
            public List<Map<String, Object>> getAgentLogList(short i, int i1) throws DataServerException {
                return null;
            }

            @Override
            public List<Map<String, Object>> findPeriodAgentLogList(short i, int i1) throws DataServerException {
                return null;
            }

            @Override
            public byte[] getAgentLogFile(short i, int i1, String s) throws DataServerException {
                return new byte[0];
            }

            @Override
            public List<Map<String, Object>> getOrderedAgentList(short i, short i1) throws DataServerException {
                return null;
            }

            @Override
            public List<Map<String, Object>> getOrderedSessionList(short i, short i1) throws DataServerException {
                return null;
            }

            @Override
            public Map<Integer, Map<String, Object>> getSessionMapByOid(short i, short i1) throws DataServerException {
                return null;
            }

            @Override
            public void sortAgentList(short i, List<Map<String, Object>> list) {

            }

            @Override
            public int[] getAliveOidList(short i) throws DataServerException {
                return new int[0];
            }
        };
    }

    @Bean
    public StandardDataService getStandardDataService() {
        return new StandardDataService() {
            @Override
            public TMAP getParam(StoreKey storeKey, Date date) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA getData(short i, StoreKey storeKey, String s) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA getData24H(short i, StoreKey storeKey, String s) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA findData24H(short i, StoreKey storeKey, String s, byte b) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA findData24H(short i, StoreKey storeKey, Date date) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA getData5Min(short i, StoreKey storeKey, String s) throws DataServerException {
                return null;
            }

            @Override
            public NUMBERA findData5Min(short i, StoreKey storeKey, Date date) throws DataServerException {
                return null;
            }
        };
    }

    @Bean
    public XViewService getXViewService() {
        return new XViewService() {
            @Override
            public List<TransactionViewData> searchByTimeRange(short i, int[] ints, long l, long l1) throws DataServerException {
                return null;
            }

            @Override
            public ViewDataResponseFuture<List<TransactionViewData>> searchKeys(short i, long l, long l1, long[] longs) throws DataServerException {
                return null;
            }

            @Override
            public TransactionViewData searchByTxid(short i, long l, long l1, long l2) throws DataServerException {
                return null;
            }

            @Override
            public TransactionViewData searchByTxid(short i, long l, long l1) throws DataServerException {
                return null;
            }

            @Override
            public TransactionViewData searchCallerByRemoteCallKey(short i, long l, String s) throws DataServerException {
                return null;
            }

            @Override
            public TransactionViewData searchReceiverByRemoteCallKey(short i, long l, String s) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> searchByGuidListWithStatus(short i, long l, byte[] bytes) throws DataServerException {
                return null;
            }

            @Override
            public List<TransactionViewData> searchByGuidList(short i, long l, long l1, byte[] bytes) throws DataServerException {
                return null;
            }

            @Override
            public TMAP searchByTxidClient(short i, long l, long l1, long l2) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getProfileV2(short i, long l, long l1, long l2) throws DataServerException {
                return null;
            }

            @Override
            public List<Object> listTargetMethodProfile(short i, boolean b) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getTargetMethodProfile(short i, boolean b, byte b1, String s, byte b2) throws DataServerException {
                return null;
            }

            @Override
            public boolean setTargetMethodProfile(short i, boolean b, byte b1, String s, byte b2, boolean b3, int[] ints, int[] ints1, String[] strings) throws DataServerException {
                return false;
            }

            @Override
            public boolean removeTargetMethodProfile(short i, boolean b, byte b1, String s, byte b2) throws DataServerException {
                return false;
            }

            @Override
            public List<Object> listTargetUserIdProfile(short i) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getTargetUserIdProfile(short i, byte b, String s) throws DataServerException {
                return null;
            }

            @Override
            public boolean setTargetUserIdProfile(short i, byte b, String s, boolean b1, int[] ints, int[] ints1) throws DataServerException {
                return false;
            }

            @Override
            public boolean removeTargetUserIdProfile(short i, byte b, String s) throws DataServerException {
                return false;
            }

            @Override
            public List<Object> listTargetGuidProfile(short i) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getTargetGuidProfile(short i, byte b, String s) throws DataServerException {
                return null;
            }

            @Override
            public boolean setTargetGuidProfile(short i, byte b, String s, boolean b1, int[] ints, int[] ints1) throws DataServerException {
                return false;
            }

            @Override
            public boolean removeTargetGuidProfile(short i, byte b, String s) throws DataServerException {
                return false;
            }

            @Override
            public List<Map<String, Object>> getProfileAPIList(short i) throws DataServerException {
                return null;
            }

            @Override
            public boolean setProfileAPI(short i, byte b, String s, String s1) throws DataServerException {
                return false;
            }

            @Override
            public boolean removeProfileAPI(short i, byte b, String s) throws DataServerException {
                return false;
            }

            @Override
            public TLIST getApiSettingList(short i) throws DataServerException {
                return null;
            }

            @Override
            public List<Map<String, Object>> getXViewErrorList(short i, long l, long l1, long l2, long l3) throws DataServerException {
                return null;
            }

            @Override
            public PiDataFormat[] formatProfile(short i, long l, long l1, PiData[] piData, byte b) throws DataServerException {
                return new PiDataFormat[0];
            }
        };
    }

    @Bean
    public ActiveServiceService getActiveServiceService() {
        return new ActiveServiceService(getAgentService(), getXViewService()) {

        };
    }

    @Bean
    public RealtimeDataService getRealtimeDataService() {
        return new RealtimeDataService() {

            @Override
            public List<TimeAndValue> rawData(short i, byte b, short i1, int i2, long l, long l1) throws DataServerException {
                return null;
            }

            @Override
            public TLIST getLast(short i, Vector<StoreKey> vector) throws DataServerException {
                return null;
            }

            @Override
            public ViewDataResponseFuture<TLIST> getLast(short i, List<StoreKey> list) throws DataServerException {
                return null;
            }

            @Override
            public RealtimeMetricsRecord[] getSysCpus(short[] shorts) throws DataServerException {
                return new RealtimeMetricsRecord[0];
            }

            @Override
            public Map<Integer, CpuUsageViewData> getSysCPUBySection(short i) throws DataServerException {
                return null;
            }

            @Override
            public TMAP getRecentData(short i, List<StoreKey> list, JSONObject jsonObject, long l) throws JSONException, DataServerException {
                return null;
            }

            @Override
            public FLOATS getBizServiceDetailRate(short i, int i1) throws DataServerException {
                return null;
            }

            @Override
            public FLOATS getBizServiceDetailTime(short i, int i1) throws DataServerException {
                return null;
            }
        };
    }

    @Bean
    public DBSearchService getDBSearchService() {
        return new DBSearchService() {

            @Override
            public MetricsCollection searchMetrics(short i, long l, long l1, int i1, byte[] bytes, String[] strings, short[] shorts, String[] strings1, int i2, int i3) throws DataServerException {
                return null;
            }

            @Override
            public MetricsCollection searchErrorCount(short i, long l, long l1, byte b, int[] ints, short[] shorts) throws DataServerException {
                return null;
            }

            @Override
            public ViewDataResponseFuture<TLIST> findMetricsData(short i, long l, long l1, long l2, byte b, int[] ints, short i1) throws DataServerException {
                return null;
            }

            @Override
            public TLIST findMetricsData(short i, long l, long l1, long l2, byte[] bytes, String[] strings, short[] shorts, String[] strings1, int i1, int i2) throws DataServerException {
                return null;
            }

            @Override
            public List<Object>[] findMetricsDataList(TLIST tlist, long l, int i, int i1) {
                return new List[0];
            }

            @Override
            public double[] findMetricsData(Map<Short, Set<Integer>> map, long l, long l1, long l2, byte b, short i) throws DataServerException {
                return new double[0];
            }

            @Override
            public TLIST findMetricsMergeData(short i, long l, long l1, long l2, byte b, int[] ints, short i1, byte b1) throws DataServerException {
                return null;
            }

            @Override
            public TMAP findMetricsCompareData(short i, long[] longs, long[] longs1, long l, byte b, int i1, short i2, String s) throws DataServerException {
                return null;
            }

            @Override
            public TLIST findMetricsSeveralData(short i, long l, long l1, long l2, byte b, int[] ints, short i1, byte b1) throws DataServerException {
                return null;
            }

            @Override
            public TLIST findMetricsDataForEvent(short i, long l, long l1, byte b, int[] ints, short[] shorts, byte[] bytes) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findServiceData(short i, long l, long l1, long l2, byte b, byte b1, int[] ints, int[] ints1, int i1, int i2) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findErrorCountGroupByInterval(short i, long l, long l1, long l2, byte b, int[] ints, short[] shorts) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findErrorCountGroupByObject(short i, long l, long l1, byte b, int[] ints, short[] shorts) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findErrorCountGroupByErrorType(short i, long l, long l1, byte b, int[] ints, short[] shorts) throws DataServerException {
                return null;
            }

            @Override
            public TMAP findErrorTableCount(short i, long l, long l1, long l2, byte b, int[] ints, short[] shorts, long l3) throws DataServerException {
                return null;
            }

            @Override
            public TMAP findErrorTableList(short i, long l, long l1, byte b, int[] ints, short[] shorts, int i1, long l2) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findEventCountGroupByInterval(short i, long l, long l1, long l2, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findEventCountGroupByObject(short i, long l, long l1, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findEventCountGroupByType(short i, long l, long l1, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findEventCountGroupByLevel(short i, long l, long l1, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3) throws DataServerException {
                return null;
            }

            @Override
            public TMAP findEventTableList(short i, long l, long l1, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3, int i1, long l2) throws DataServerException {
                return null;
            }

            @Override
            public TMAP findEventTableCount(short i, long l, long l1, long l2, byte b, int[] ints, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3, long l3) throws DataServerException {
                return null;
            }

            @Override
            public INTS findMetricsTopN(short i, long l, long l1, byte b, int[] ints, short i1, byte b1, int i2) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findServiceTopN(short i, long l, long l1, byte b, byte b1, String s, int[] ints, int i1) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findEventTopN(short i, long l, long l1, byte b, int[] ints, boolean b1, short[] shorts, byte[] bytes, boolean b2, boolean b3, int i1) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findErrorTopN(short i, long l, long l1, byte b, int[] ints, short[] shorts, int i1) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findMetricsSummary(short i, String s, String s1, long l, long l1, long l2, byte b, int[] ints, short[] shorts, byte[] bytes) throws DataServerException {
                return null;
            }

            @Override
            public TABLE findMetricsSummary(short i, String s, String s1, long l, long l1, long l2, byte b, int[] ints, short[] shorts) throws DataServerException {
                return null;
            }

            @Override
            public String getSessionKeyForEventList(Map<Short, Set<Integer>> map, long l, long l1, byte b, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getEventListWithSessionKey(String s) throws DataServerException {
                return null;
            }

            @Override
            public String getSessionKeyForEventCount(Map<Short, Set<Integer>> map, long l, long l1, byte b, short[] shorts, byte[] bytes, boolean b1, boolean b2, boolean b3, boolean b4, long l2, boolean b5, boolean b6) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getEventCountWithSessionKey(byte b, String s) throws DataServerException {
                return null;
            }

            @Override
            public String getSessionKeyForErrorList(Map<Short, Set<Integer>> map, long l, long l1, byte b, short[] shorts, int i) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getErrorListWithSessionKey(String s) throws DataServerException {
                return null;
            }

            @Override
            public String getSessionKeyForErrorCount(Map<Short, Set<Integer>> map, long l, long l1, byte b, short[] shorts, long l2, int i) throws DataServerException {
                return null;
            }

            @Override
            public Map<String, Object> getErrorCountWithSessionKey(byte b, boolean b1, String s) throws DataServerException {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RealtimeApiApplication.class, args);
    }
}