package repositorios;

//Repositório Agendamento

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
