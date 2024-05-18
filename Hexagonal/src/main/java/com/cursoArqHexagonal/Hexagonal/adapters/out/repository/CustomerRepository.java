package com.cursoArqHexagonal.Hexagonal.adapters.out.repository;

import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
