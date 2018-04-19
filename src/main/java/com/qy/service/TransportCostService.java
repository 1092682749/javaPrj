package com.qy.service;
import com.qy.model.Address;
import com.qy.model.TransportCost;
import com.qy.base.core.Service;


/**
 * Created by zaq on 2018/04/14.
 */
public interface TransportCostService extends Service<TransportCost> {
        public TransportCost findCost(Address address);
}
