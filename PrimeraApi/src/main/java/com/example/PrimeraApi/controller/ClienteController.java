package com.example.PrimeraApi.controller;

import com.example.PrimeraApi.model.entity.Cliente;
import com.example.PrimeraApi.service.iCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class ClienteController {

        @Autowired
        private iCliente clienteService;

        @PostMapping("clientes")
        public Cliente create(@RequestBody Cliente cliente){

            return clienteService.save(cliente);
        }
        @PutMapping("cliente")
        public Cliente update( @RequestBody Cliente cliente){
            return clienteService.save(cliente);

        }
        @DeleteMapping("cliente/{id}")
        public void delete(@PathVariable Integer id){
            Cliente cliente=clienteService.findById(id);
             clienteService.delete(cliente);
        }

        @GetMapping("clientes/{id}")
        public Cliente showById(@PathVariable Integer id){

           return clienteService.findById(id);
        }


}
