package repositorios;

//Repositório Solicitante

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
}