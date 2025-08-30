package com.example.agendamentoclinicathay.repository;

import com.example.agendamentoclinicathay.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

