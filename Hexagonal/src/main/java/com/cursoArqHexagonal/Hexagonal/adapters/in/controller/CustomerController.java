package com.cursoArqHexagonal.Hexagonal.adapters.in.controller;

import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.request.CustomerRequest;
import com.cursoArqHexagonal.Hexagonal.adapters.in.controller.response.CustomerResponse;
import com.cursoArqHexagonal.Hexagonal.application.core.domain.Customer;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.InsertCustomerInputPort;
import com.cursoArqHexagonal.Hexagonal.application.ports.in.UpdateCustomerInputPort;
import feign.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CustomerRequest customerRequest, @PathVariable final String id){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode()); //Não entendi esta parte
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
