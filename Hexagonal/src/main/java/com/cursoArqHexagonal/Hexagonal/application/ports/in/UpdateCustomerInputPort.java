package com.cursoArqHexagonal.Hexagonal.application.ports.in;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.core.usecase.UpdateCustomerUseCase;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
