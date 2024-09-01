package br.com.etechoracio.PW3_Study.controller;
import br.com.etechoracio.PW3_Study.entify.Disciplina;
import br.com.etechoracio.PW3_Study.repository.DisciplinaRepository;
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
    private DisciplinaRepository repository;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);
        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<Disciplina> inserir(@RequestBody Disciplina disciplina){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(disciplina));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(disciplina));

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Disciplina> excluir(@PathVariable Long id, @RequestBody Disciplina disciplina ){
        var existe = repository.findById(id);
        if(!existe.isPresent()){
            return ResponseEntity.notFound().build();
        }
        else{
            repository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }


}