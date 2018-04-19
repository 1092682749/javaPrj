package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Address;

import java.util.List;

public interface AddressMapper extends Mapper<Address> {
    public Address findDefaultAddress(Integer id);
    public List<Address> findAddressByMemberId(Integer id);
}