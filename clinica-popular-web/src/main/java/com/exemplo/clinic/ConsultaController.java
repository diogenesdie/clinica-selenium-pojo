package com.exemplo.clinic;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private Map<String, Paciente> pacientes = new HashMap<>();

    @PostMapping
    public String agendarConsulta(@RequestParam String nome, @RequestParam String cpf, @RequestParam String dataHora) {
        Paciente paciente = pacientes.getOrDefault(cpf, new Paciente(nome, cpf));
        paciente.adicionarConsulta(new Consulta(dataHora));
        pacientes.put(cpf, paciente);
        return "Consulta marcada para " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")";
    }
}
