package com.example.agendamentoclinicathay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Pessoa pessoa; //campo que referencia a outra entidade

    private String cargo;
    private String especialidade;
    private String conselhoNumero;

    // Getters e Setters
}
