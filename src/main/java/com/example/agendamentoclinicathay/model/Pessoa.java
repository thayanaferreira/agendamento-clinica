package com.example.agendamentoclinicathay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

}


// que campos eu preciso?? // declarar e priva-los
//criar getter e setters
// adicionar anotação entity
// adicionar anotação: da primary key da tabela
// adicionar anotação: da table
