package com.cursoArqHexagonal.Hexagonal.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data //Gera os métodos Getters e Setters
@Builder //Gera um Construtor para a Classe com apenas os campos que você escolher
@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
public class Customer {
    public Customer(){
        this.isValidCpf = false;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;

}
