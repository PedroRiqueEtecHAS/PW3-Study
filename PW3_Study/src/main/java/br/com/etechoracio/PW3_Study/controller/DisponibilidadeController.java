package br.com.etechoracio.PW3_Study.controller;
import br.com.etechoracio.PW3_Study.entify.Disponibilidade;
import br.com.etechoracio.PW3_Study.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {

    @Autowired
    private DisponibilidadeRepository repository;

    @GetMapping
    public List<Disponibilidade> listarDisponibilidade() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Disponibilidade> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);
        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<Disponibilidade> inserir(@RequestBody Disponibilidade disponibilidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(disponibilidade));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Disponibilidade> atualizar(@PathVariable Long id, @RequestBody Disponibilidade disponibilidade){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(disponibilidade));

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Disponibilidade> excluir(@PathVariable Long id, @RequestBody Disponibilidade disponibilidade ){
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