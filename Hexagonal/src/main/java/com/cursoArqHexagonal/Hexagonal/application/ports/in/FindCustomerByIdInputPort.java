package com.cursoArqHexagonal.Hexagonal.application.ports.in;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    public Customer find(String id);
}
