package br.com.etechoracio.PW3_Study.controller;

import br.com.etechoracio.PW3_Study.entify.Conexao;
import br.com.etechoracio.PW3_Study.repository.ConexaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ConexaoController {

    @Autowired
    private ConexaoRepository repository;

    @GetMapping
    public List<Conexao> listarConexao() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Conexao> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);

        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<Conexao> inserir(@RequestBody Conexao conexao){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conexao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conexao> atualizar(@PathVariable Long id, @RequestBody Conexao conexao){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(conexao));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Conexao> excluir(@PathVariable Long id, @RequestBody Conexao conexao ){
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
