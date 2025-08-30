package com.example.agendamentoclinicathay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private Long id;

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "id")
    private Pessoa pessoa;

    @Setter
    private String convenio;
    @Setter
    private String numeroCarteira;
    @Setter
    private LocalDate validadeCarteira;
}
