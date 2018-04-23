package com.qy.service.impl;

import com.qy.dao.AddressMapper;
import com.qy.model.Address;
import com.qy.service.AddressService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class AddressServiceImpl extends AbstractService<Address> implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public Address findDefaultAddress(Integer id) {
        return addressMapper.findDefaultAddress(id);
    }

    @Override
    public List<Address> findAddressByMemberId(Integer id) {
        return addressMapper.findAddressByMemberId(id);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }
}
