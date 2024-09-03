package br.com.etechoracio.PW3_Study.service;

import br.com.etechoracio.PW3_Study.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;


}
