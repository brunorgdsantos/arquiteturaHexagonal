package com.cursoArqHexagonal.Hexagonal.adapters.out;

import com.cursoArqHexagonal.Hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.cursoArqHexagonal.Hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.CustomerRepository;
import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
