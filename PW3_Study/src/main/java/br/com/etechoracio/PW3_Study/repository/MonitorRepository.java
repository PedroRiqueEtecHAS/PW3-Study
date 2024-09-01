package br.com.etechoracio.PW3_Study.repository;
import br.com.etechoracio.PW3_Study.entify.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}