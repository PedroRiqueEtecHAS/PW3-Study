package br.com.etechoracio.PW3_Study.entify;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TBL_REL_MONITOR_DISPONIBILIDADE")
public class MonitorDisponibilidade {

    @Id
    @Column(name = "ID_MONITOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMonitor;

    @Id
    @Column(name = "ID_DISPONIBILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibilidade;
}
