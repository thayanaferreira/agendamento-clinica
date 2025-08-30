package com.example.agendamentoclinicathay.repository;

import com.example.agendamentoclinicathay.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
