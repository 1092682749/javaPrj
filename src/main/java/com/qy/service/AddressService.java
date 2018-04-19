package com.qy.service;
import com.qy.model.Address;
import com.qy.base.core.Service;

import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
public interface AddressService extends Service<Address> {
    public Address findDefaultAddress(Integer id);
    public List<Address> findAddressByMemberId(Integer id);
}
