package com.cursoArqHexagonal.Hexagonal.application.core.usecase;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.InsertCustomerInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
public class InsertCustomerUseCase implements InsertCustomerInputPort { //Inserindo um cliente

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    @Override
    public void insert(Customer customer, String zipCode){ //zipCode = CEP (Vai vir de outro Microserviço)
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
