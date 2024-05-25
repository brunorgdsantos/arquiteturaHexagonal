package com.cursoArqHexagonal.Hexagonal.config;

import com.cursoArqHexagonal.Hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.cursoArqHexagonal.Hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.cursoArqHexagonal.Hexagonal.adapters.out.UpdateCustomerAdapter;
import com.cursoArqHexagonal.Hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.cursoArqHexagonal.Hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
