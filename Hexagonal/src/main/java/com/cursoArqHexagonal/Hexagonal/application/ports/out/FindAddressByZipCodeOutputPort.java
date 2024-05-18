package com.cursoArqHexagonal.Hexagonal.application.ports.out;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode); //Estou inserindo uma String(zipCode) porém o retorno é um Endereço (Address)
}
