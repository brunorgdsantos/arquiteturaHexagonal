package com.cursoArqHexagonal.Hexagonal.adapters.in.consumer.mapper;

import com.cursoArqHexagonal.Hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    @Mapping(target = "address", ignore = true)
    public Customer toCustomer(CustomerMessage customerMessage);
}
