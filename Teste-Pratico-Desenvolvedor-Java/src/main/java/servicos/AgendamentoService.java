package servicos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors; // Importe a classe Collectors

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

    public Agendamento criarAgendamento(Agendamento agendamento) {
        LocalDate data = agendamento.getData(); // Use getData()
        
        // Obter vagas para o período e contar quantos agendamentos já existem
        List<Vaga> vagas = vagaRepository.findAll();
        long agendamentosExistentes = agendamentoRepository
            .findAll()
            .stream()
            .filter(a -> a.getData().equals(data)) // Use getData()
            .count();

        Vaga vaga = vagas.stream()
            .filter(v -> v.getQuantidade() > agendamentosExistentes) // Use getQuantidade()
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Sem vagas para esta data"));

        if (agendamentosExistentes >= vaga.getQuantidade()) {
            throw new IllegalStateException("Vagas esgotadas para esta data");
        }

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarAgendamentos(LocalDate inicio, LocalDate fim) {
        return agendamentoRepository
            .findAll()
            .stream()
            .filter(a -> !a.getData().isBefore(inicio) && !a.getData().isAfter(fim)) // Use getData()
            .collect(Collectors.toList()); // Use collect(Collectors.toList())
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
