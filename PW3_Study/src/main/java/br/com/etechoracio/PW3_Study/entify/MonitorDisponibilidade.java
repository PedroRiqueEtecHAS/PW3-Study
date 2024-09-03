package br.com.etechoracio.PW3_Study.entify;
//Henrique Lopes e Pedro Soares
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TBL_REL_MONITOR_DISPONIBILIDADE")
public class MonitorDisponibilidade {

   
    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private Monitor idMonitor;

    @ManyToOne
    @JoinColumn(name = "ID_DISPONIBILIDADE")
    private Disponibilidade idDisponibilidade;
}
