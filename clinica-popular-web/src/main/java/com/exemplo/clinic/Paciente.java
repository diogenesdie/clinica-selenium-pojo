package com.exemplo.clinic;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String cpf;
    private List<Consulta> consultas = new ArrayList<>();

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public List<Consulta> getConsultas() { return consultas; }
}
