package com.cursoArqHexagonal.Hexagonal.config;

import com.cursoArqHexagonal.Hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.cursoArqHexagonal.Hexagonal.adapters.out.InsertCustomerAdapter;
import com.cursoArqHexagonal.Hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.cursoArqHexagonal.Hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter,
                                                       SendCpfForValidationAdapter sendCpfForValidationAdapter){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
