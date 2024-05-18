package com.cursoArqHexagonal.Hexagonal.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos Getters e Setters
@Builder //Gera um Construtor para a Classe com apenas os campos que você escolher
@NoArgsConstructor //Gera um Construtor sem argumentos (Parâmetros) para a Classe
@AllArgsConstructor //Gera um Construtor com todos os argumentos (Parâmetros) para a Classe
public class Address {

    private String street;

    private String city;

    private String state;

}
