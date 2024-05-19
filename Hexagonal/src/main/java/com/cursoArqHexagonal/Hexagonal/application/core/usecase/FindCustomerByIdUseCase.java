package com.cursoArqHexagonal.Hexagonal.application.core.usecase;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not find!"));
    }
}
