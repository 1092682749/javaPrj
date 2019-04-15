package com.conpany.project;

import com.qy.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class FindTest extends Tester {
    @Autowired
    AddressService addressService;
    @Test
    public void t()
    {
        addressService.findById(1);
    }
}
