package servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Agendamento;
import repositorios.AgendamentoRepository;
import repositorios.VagaRepository;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> buscarAgendamentos(LocalDate inicio, LocalDate fim) {
        return agendamentoRepository.findByDataBetween(inicio, fim);
    }

    // Método para calcular o total de vagas disponíveis em um intervalo de datas
    public int calcularTotalVagas(LocalDate inicio, LocalDate fim) {
        List<Agendamento> agendamentos = buscarAgendamentos(inicio, fim);
        int totalVagasUsadas = agendamentos.size();
        int totalVagasDisponiveis = vagaRepository.findAll().size();
        return totalVagasDisponiveis - totalVagasUsadas;
    }

    // Método para injetar um repositório mock para testes
    public void setAgendamentoRepository(AgendamentoRepository repositoryMock) {
        this.agendamentoRepository = repositoryMock;
    }
}
