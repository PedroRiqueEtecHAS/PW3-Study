package br.com.etechoracio.PW3_Study.controller;

import br.com.etechoracio.PW3_Study.entify.Conexao;
import br.com.etechoracio.PW3_Study.entify.MonitorDisponibilidade;
import br.com.etechoracio.PW3_Study.repository.ConexaoRepository;
import br.com.etechoracio.PW3_Study.repository.MonitorDisponilidadeRepository;
import br.com.etechoracio.PW3_Study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MonitorDisponibilidadeController {

    @Autowired
    private MonitorDisponilidadeRepository repository;

    @GetMapping
    public List<MonitorDisponibilidade> listarMonitor() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDisponibilidade> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);

        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<MonitorDisponibilidade> inserir(@RequestBody MonitorDisponibilidade monitorDisponibilidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(monitorDisponibilidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorDisponibilidade> atualizar(@PathVariable Long id, @RequestBody MonitorDisponibilidade monitorDisponibilidade){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(monitorDisponibilidade));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<MonitorDisponibilidade> excluir(@PathVariable Long id, @RequestBody MonitorDisponibilidade monitorDisponibilidade ){
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
