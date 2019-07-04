package com.aries.realtimeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class RealtimeDomainDataSet
{
    @JsonProperty("result")
    List<RealtimeDomainData> list;

    public List<RealtimeDomainData> getList()
    {
        return list;
    }

    public void setList(List<RealtimeDomainData> list)
    {
        this.list = list;
    }
}
