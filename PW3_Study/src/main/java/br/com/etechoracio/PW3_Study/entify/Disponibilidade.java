package br.com.etechoracio.PW3_Study.entify;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")

public class Disponibilidade {

    @Id
    @Column(name = " ID_DISPONIBILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DIA_SEMANA")
    private String diaSemana;

    @Column(name = " DT_DAS")
    private LocalDateTime das;

    @Column(name = "DT_ATE")
    private LocalDateTime ate;


}