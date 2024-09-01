package br.com.etechoracio.PW3_Study.controller;
import br.com.etechoracio.PW3_Study.entify.Monitor;
import br.com.etechoracio.PW3_Study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorRepository repository;

    @GetMapping
    public List<Monitor> listarMonitores() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Monitor> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);
        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<Monitor> inserir(@RequestBody Monitor monitor){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(monitor));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Monitor> atualizar(@PathVariable Long id, @RequestBody Monitor monitor){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(monitor));

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Monitor> excluir(@PathVariable Long id, @RequestBody Monitor monitor ){
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