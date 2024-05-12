package repositorios;

import java.time.LocalDate;
import java.util.List;

//Repositório Agendamento

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<Agendamento> findByDataBetween(LocalDate inicio, LocalDate fim);
}
