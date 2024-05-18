package com.cursoArqHexagonal.Hexagonal.application.ports.out;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer); //Inserindo um cliente na Base de dados
}
