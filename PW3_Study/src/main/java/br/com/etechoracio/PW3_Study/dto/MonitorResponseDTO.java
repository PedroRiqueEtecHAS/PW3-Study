package br.com.etechoracio.PW3_Study.dto;
// Henrique Lopes e Pedro Soares


import br.com.etechoracio.PW3_Study.entify.Disciplina;
import lombok.Data;
@Data
public class MonitorResponseDTO {

    private String nome;

    private String foto;

    private String whatsapp;

    private String email;

    private String conteudo;

    private DisciplinaResponseDTO disciplina;
}