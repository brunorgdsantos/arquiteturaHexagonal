package com.cursoArqHexagonal.Hexagonal.application.ports.in;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipcode);
}
