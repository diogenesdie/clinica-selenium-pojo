import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaServiceTest {

    @Test
    public void testAgendarConsultaParaNovoPaciente() {
        ConsultaService service = new ConsultaService();
        service.agendarConsulta("12345678900", "João", "2025-07-10 10:00");

        Paciente paciente = service.getPacientePorCpf("12345678900");
        assertNotNull(paciente);
        assertEquals("João", paciente.getNome());
        assertEquals(1, paciente.getConsultas().size());
        assertEquals("2025-07-10 10:00", paciente.getConsultas().get(0).getDataHora());
    }

    @Test
    public void testAgendarMultiplasConsultasParaMesmoPaciente() {
        ConsultaService service = new ConsultaService();
        service.agendarConsulta("12345678900", "Maria", "2025-07-10 10:00");
        service.agendarConsulta("12345678900", "Maria", "2025-07-11 11:00");

        Paciente paciente = service.getPacientePorCpf("12345678900");
        assertEquals(2, paciente.getConsultas().size());
    }
}
