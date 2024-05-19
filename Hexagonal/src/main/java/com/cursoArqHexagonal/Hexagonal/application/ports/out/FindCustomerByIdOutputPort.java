package com.cursoArqHexagonal.Hexagonal.application.ports.out;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
