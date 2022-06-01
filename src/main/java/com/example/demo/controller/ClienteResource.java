package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Integer id){

        Cliente cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok().body(cliente);
    }
}
