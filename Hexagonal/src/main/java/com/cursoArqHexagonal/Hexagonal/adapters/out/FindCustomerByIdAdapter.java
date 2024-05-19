package com.cursoArqHexagonal.Hexagonal.adapters.out;

import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.CustomerRepository;
import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
@AllArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private CustomerRepository customerRepository;

    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
