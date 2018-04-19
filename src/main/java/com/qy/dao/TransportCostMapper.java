package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Address;
import com.qy.model.TransportCost;

public interface TransportCostMapper extends Mapper<TransportCost> {
    public TransportCost findCost(Address address);
}