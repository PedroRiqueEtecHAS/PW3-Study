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
@Table(name = "TBL_MONITOR")

public class Monitor {

    @Id
    @Column(name = " ID_MONITOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_FOTO")
    private String foto;

    @Column(name = "TX_WHATSAPP")
    private String whatsapp;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @Column(name = "TX_DISCIPLINA")
    private BigInteger disciplina;
}