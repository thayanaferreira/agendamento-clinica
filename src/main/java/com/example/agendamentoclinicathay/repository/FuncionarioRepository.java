package com.example.agendamentoclinicathay.repository;

import com.example.agendamentoclinicathay.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

