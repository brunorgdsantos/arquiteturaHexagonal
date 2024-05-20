package com.cursoArqHexagonal.Hexagonal.application.ports.out;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
