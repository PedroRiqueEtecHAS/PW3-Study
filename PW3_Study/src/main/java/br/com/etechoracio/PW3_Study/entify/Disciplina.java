package br.com.etechoracio.PW3_Study.entify;
//Henrique Lopes e Pedro Soares
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "TBL_DISCIPLINA")

public class Disciplina {

    @Id
    @Column(name = " ID_DISCIPLINA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;
}