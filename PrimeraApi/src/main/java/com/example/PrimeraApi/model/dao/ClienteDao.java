package com.example.PrimeraApi.model.dao;

import com.example.PrimeraApi.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Integer> {
}
