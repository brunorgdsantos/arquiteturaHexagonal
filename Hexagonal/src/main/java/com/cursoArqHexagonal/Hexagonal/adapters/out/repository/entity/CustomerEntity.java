package com.cursoArqHexagonal.Hexagonal.adapters.out.repository.entity;

import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;

    private String name;

    private AddressEntity address;

    private String cpf;

    private Boolean isValidCpf;
}
