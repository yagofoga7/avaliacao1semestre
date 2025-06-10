package com.nome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nome.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

