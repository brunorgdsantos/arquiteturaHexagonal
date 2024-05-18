package com.cursoArqHexagonal.Hexagonal.adapters.out.repository.mapper;

import com.cursoArqHexagonal.Hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
