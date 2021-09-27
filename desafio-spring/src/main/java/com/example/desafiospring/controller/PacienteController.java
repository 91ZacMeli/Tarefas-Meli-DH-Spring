package com.example.desafiospring.controller;

import com.example.desafiospring.dto.PacienteDTO;
import com.example.desafiospring.persistence.PacientePersistence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacientePersistence pacientePersistence = new PacientePersistence();

    @PostMapping("/cadastra")
    public ResponseEntity<PacienteDTO> cadastraPaciente(@RequestBody PacienteDTO payLoad, UriComponentsBuilder uriBuilder) {
        pacientePersistence.salvarPacienteNoArquivo(payLoad);
        URI uri = uriBuilder.path("/codigo/{codigo}").buildAndExpand(payLoad.getNumeroColeira()).toUri();
        return ResponseEntity.created(uri).body(payLoad);
    }

    @GetMapping("listar")
    public List<PacienteDTO> mostrarPacientes() {
        return pacientePersistence.buscarPaciente();
    }

    @PutMapping("/alterar/{numeroColeira}")
    public ResponseEntity<PacienteDTO> alterarPaciente(@RequestBody PacienteDTO payLoad, UriComponentsBuilder uriBuilder) {
        pacientePersistence.alterarPaciente(payLoad);
        URI uri = uriBuilder.path("/alterado/{numeroColeira}").buildAndExpand(payLoad.getNumeroColeira()).toUri();
        return ResponseEntity.created(uri).body(payLoad);
    }

    @DeleteMapping("/deleta/{numeroColeira}")
    public void removerPaciente(@PathVariable String numeroColeira){
        pacientePersistence.removerPacientePorId(numeroColeira);
    }
}