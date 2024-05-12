package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import entidades.Agendamento;
import repositorios.AgendamentoRepository;
import servicos.AgendamentoService;

public class AgendamentoServiceTest {

    @Test
    void testBuscarAgendamentos() {
        LocalDate inicio = LocalDate.now();
        LocalDate fim = LocalDate.now().plusDays(7);
        Agendamento agendamento = new Agendamento();
        agendamento.setData(LocalDate.now());

        AgendamentoRepository repositoryMock = mock(AgendamentoRepository.class);
        when(repositoryMock.findByDataBetween(inicio, fim)).thenReturn(Collections.singletonList(agendamento));

        AgendamentoService service = new AgendamentoService();
        service.setAgendamentoRepository(repositoryMock);

        List<Agendamento> agendamentos = service.buscarAgendamentos(inicio, fim);
        assertEquals(1, agendamentos.size());
        assertEquals(agendamento, agendamentos.get(0));
    }
}
