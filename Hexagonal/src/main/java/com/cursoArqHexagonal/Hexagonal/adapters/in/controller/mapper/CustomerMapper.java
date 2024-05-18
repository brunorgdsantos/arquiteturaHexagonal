package com.cursoArqHexagonal.Hexagonal.adapters.in.controller.mapper;

import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import org.hibernate.id.uuid.CustomVersionOneStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}