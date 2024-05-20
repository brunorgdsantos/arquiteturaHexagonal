package com.cursoArqHexagonal.Hexagonal.application.core.usecase;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
