package br.com.etechoracio.PW3_Study.repository;
import br.com.etechoracio.PW3_Study.entify.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Long> {

}