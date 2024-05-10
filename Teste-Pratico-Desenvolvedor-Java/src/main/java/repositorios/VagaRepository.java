package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}