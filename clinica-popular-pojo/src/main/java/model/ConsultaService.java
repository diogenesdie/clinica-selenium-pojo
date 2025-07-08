import java.util.HashMap;
import java.util.Map;

public class ConsultaService {
    private Map<String, Paciente> pacientes = new HashMap<>();

    public void agendarConsulta(String cpf, String nome, String dataHora) {
        Paciente paciente = pacientes.getOrDefault(cpf, new Paciente(nome, cpf));
        Consulta consulta = new Consulta(dataHora);
        paciente.adicionarConsulta(consulta);
        pacientes.put(cpf, paciente);
    }

    public Paciente getPacientePorCpf(String cpf) {
        return pacientes.get(cpf);
    }
}
