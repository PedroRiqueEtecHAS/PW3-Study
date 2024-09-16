// Henrique Lopes e Pedro Soares

package br.com.etechoracio.PW3_Study.service;

import br.com.etechoracio.PW3_Study.dto.MonitorResponseDTO;
import br.com.etechoracio.PW3_Study.repository.MonitorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository repository;

    private final ModelMapper modelMapper = new ModelMapper();
    public List<MonitorResponseDTO> listar(){
        var monitores = repository.findAll();
        return monitores.stream().map(
                e-> modelMapper.map(e, MonitorResponseDTO.class)
        ).collect(Collectors.toList());
    }
}
