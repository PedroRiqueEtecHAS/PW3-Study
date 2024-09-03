package br.com.etechoracio.PW3_Study.entify;
//Henrique Lopes e Pedro Soares
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {

    @Id
    @Column(name = "ID_CONEXAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_MONITOR", nullable = false)
    private Monitor idMonitor;
}
