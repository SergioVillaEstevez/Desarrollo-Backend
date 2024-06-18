package com.example.PrimeraApi.service;

import com.example.PrimeraApi.model.entity.Cliente;

public interface iCliente {

    Cliente save(Cliente cliente);
    Cliente findById(Integer id);

    void delete(Cliente cliente);


}
