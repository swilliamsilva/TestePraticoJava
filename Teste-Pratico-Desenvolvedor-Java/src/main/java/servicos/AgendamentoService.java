package servicos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Agendamento;
import entidades.Vaga;
import repositorios.AgendamentoRepository;
import repositorios.VagaRepository;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    // Método para criar um agendamento
    public Agendamento criarAgendamento(Agendamento agendamento) {
        LocalDate data = agendamento.getData();
        List<Vaga> vagas = vagaRepository.findAll();

        // Conte os agendamentos existentes para a data específica
        long agendamentosExistentes = agendamentoRepository
            .findAll()
            .stream()
            .filter(a -> a.getData().equals(data))
            .count();

        // Encontre uma vaga disponível para a data
        Vaga vaga = vagas.stream()
            .filter(v -> v.getQuantidade() > agendamentosExistentes)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Sem vagas para esta data"));

        if (agendamentosExistentes >= vaga.getQuantidade()) {
            throw new IllegalStateException("Vagas esgotadas para esta data");
        }

        return agendamentoRepository.save(agendamento);
    }

    // Método para buscar agendamentos entre duas datas
    public List<Agendamento> buscarAgendamentos(LocalDate inicio, LocalDate fim) {
        return agendamentoRepository
            .findAll()
            .stream()
            .filter(a -> !a.getData().isBefore(inicio) && !a.getData().isAfter(fim))
            .collect(Collectors.toList());
    }

    // Método para calcular o total de vagas disponíveis
    public int calcularTotalVagas(LocalDate inicio, LocalDate fim) {
         
    List<Vaga> vagas = vagaRepository.findAll();
        return vagas.size(); // Modifique conforme necessário
    }

    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
