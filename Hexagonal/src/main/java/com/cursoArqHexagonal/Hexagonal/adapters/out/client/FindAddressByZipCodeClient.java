package com.cursoArqHexagonal.Hexagonal.adapters.out.client;

import com.cursoArqHexagonal.Hexagonal.adapters.out.client.response.AddressResponse;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignContext;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${arantes.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);
}
