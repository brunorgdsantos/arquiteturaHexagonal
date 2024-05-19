package com.cursoArqHexagonal.Hexagonal.adapters.in.controller;

import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.response.CustomerResponse;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZip());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

}
