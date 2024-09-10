package br.com.etechoracio.PW3_Study.controller;
import br.com.etechoracio.PW3_Study.dto.DisciplinaResponseDTO;
import br.com.etechoracio.PW3_Study.entify.Disciplina;
import br.com.etechoracio.PW3_Study.repository.DisciplinaRepository;
import br.com.etechoracio.PW3_Study.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public List<DisciplinaResponseDTO> listarDisciplinas() {return service.listar();}



}