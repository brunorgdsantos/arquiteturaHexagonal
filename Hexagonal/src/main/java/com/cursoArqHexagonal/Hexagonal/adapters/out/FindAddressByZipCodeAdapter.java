package com.cursoArqHexagonal.Hexagonal.adapters.out;

import com.cursoArqHexagonal.Hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.cursoArqHexagonal.Hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cloud.openfeign.FeignContext;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
