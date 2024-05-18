package com.cursoArqHexagonal.Hexagonal.adapters.in.controller;

import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZip());
        return ResponseEntity.ok().build();
    }
}
