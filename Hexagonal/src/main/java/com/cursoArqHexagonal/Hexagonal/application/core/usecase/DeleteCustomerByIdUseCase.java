package com.cursoArqHexagonal.Hexagonal.application.core.usecase;

import com.cursoArqHexagonal.Hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;
    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
