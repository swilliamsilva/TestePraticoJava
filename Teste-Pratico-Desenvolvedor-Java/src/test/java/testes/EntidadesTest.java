package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import entidades.Agendamento;
import entidades.Solicitante;
import entidades.Vaga;

public class EntidadesTest {

    @Test
    void testAgendamento() {
        LocalDate data = LocalDate.now();
        Agendamento agendamento = new Agendamento();
        agendamento.setId(1L);
        agendamento.setData(data);
        agendamento.setHora("09:00");

        assertEquals(1L, agendamento.getId());
        assertEquals(data, agendamento.getData());
        assertEquals("09:00", agendamento.getHora());
    }

    @Test
    void testSolicitante() {
        Solicitante solicitante = new Solicitante();
        solicitante.setId(1L);
        solicitante.setNome("João");

        assertEquals(1L, solicitante.getId());
        assertEquals("João", solicitante.getNome());
    }

    @Test
    void testVaga() {
        LocalDate inicio = LocalDate.now();
        LocalDate fim = LocalDate.now().plusDays(7);
        Vaga vaga = new Vaga();
        vaga.setId(1L);
        vaga.setInicio(inicio);
        vaga.setFim(fim);
        vaga.setQuantidade(10);

        assertEquals(1L, vaga.getId());
        assertEquals(inicio, vaga.getInicio());
        assertEquals(fim, vaga.getFim());
        assertEquals(10, vaga.getQuantidade());
    }
}
