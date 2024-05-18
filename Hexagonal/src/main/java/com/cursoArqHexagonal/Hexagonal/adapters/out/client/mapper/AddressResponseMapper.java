package com.cursoArqHexagonal.Hexagonal.adapters.out.client.mapper;

import com.cursoArqHexagonal.Hexagonal.adapters.out.client.response.AddressResponse;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
