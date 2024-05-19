package com.cursoArqHexagonal.Hexagonal.adapters.in.controller.response;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;
}
