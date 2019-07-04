package com.aries.realtimeapi.model;

public class RealtimeDomainData
{
    private short domainId;
    private String domainName;
    private String ipAddress;
    private int activeService;
    private int activeServiceRandgeCount0;
    private int activeServiceRandgeCount1;
    private int activeServiceRandgeCount2;
    private int activeServiceRandgeCount3;
    private int activeUser;
    private float tps;
    private float responseTime;
    private float concurrentUser;
    private float rejectRate;
    private int hitHour;
    private int visitHour;
    private int hitDay;
    private int visitDay;
    private int port;

    public int getHitHour()
    {
        return hitHour;
    }

    public void setHitHour(int hitHour)
    {
        this.hitHour = hitHour;
    }

    public int getVisitHour()
    {
        return visitHour;
    }

    public void setVisitHour(int visitHour)
    {
        this.visitHour = visitHour;
    }

    public int getHitDay()
    {
        return hitDay;
    }

    public void setHitDay(int hitDay)
    {
        this.hitDay = hitDay;
    }

    public int getVisitDay()
    {
        return visitDay;
    }

    public void setVisitDay(int visitDay)
    {
        this.visitDay = visitDay;
    }

    public String getDomainName()
    {
        return domainName;
    }

    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }

    public int getActiveService()
    {
        return activeService;
    }

    public void setActiveService(int activeService)
    {
        this.activeService = activeService;
    }

    public int getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(int activeUser)
    {
        this.activeUser = activeUser;
    }

    public float getTps()
    {
        return tps;
    }

    public void setTps(float tps)
    {
        this.tps = tps;
    }

    public float getResponseTime()
    {
        return responseTime;
    }

    public void setResponseTime(float responseTime)
    {
        this.responseTime = responseTime;
    }

    public float getConcurrentUser()
    {
        return concurrentUser;
    }

    public void setConcurrentUser(float concurrentUser)
    {
        this.concurrentUser = concurrentUser;
    }

    public float getRejectRate()
    {
        return rejectRate;
    }

    public void setRejectRate(float rejectRate)
    {
        this.rejectRate = rejectRate;
    }

    public short getDomainId()
    {
        return domainId;
    }

    public void setDomainId(short domainId)
    {
        this.domainId = domainId;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public int getActiveServiceRandgeCount0() {
        return activeServiceRandgeCount0;
    }

    public void setActiveServiceRandgeCount0(int activeServiceRandgeCount0) {
        this.activeServiceRandgeCount0 = activeServiceRandgeCount0;
    }

    public int getActiveServiceRandgeCount1() {
        return activeServiceRandgeCount1;
    }

    public void setActiveServiceRandgeCount1(int activeServiceRandgeCount1) {
        this.activeServiceRandgeCount1 = activeServiceRandgeCount1;
    }

    public int getActiveServiceRandgeCount2() {
        return activeServiceRandgeCount2;
    }

    public void setActiveServiceRandgeCount2(int activeServiceRandgeCount2) {
        this.activeServiceRandgeCount2 = activeServiceRandgeCount2;
    }

    public int getActiveServiceRandgeCount3() {
        return activeServiceRandgeCount3;
    }

    public void setActiveServiceRandgeCount3(int activeServiceRandgeCount3) {
        this.activeServiceRandgeCount3 = activeServiceRandgeCount3;
    }
}
