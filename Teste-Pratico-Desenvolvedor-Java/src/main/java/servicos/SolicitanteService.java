package servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Solicitante;
import repositorios.SolicitanteRepository;

@Service
public class SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    @Autowired
    public SolicitanteService(SolicitanteRepository solicitanteRepository) {
        this.solicitanteRepository = solicitanteRepository;
    }

    public List<Solicitante> listarTodos() {
        return solicitanteRepository.findAll();
    }

    public Optional<Solicitante> obterPorId(Long id) {
        return solicitanteRepository.findById(id);
    }

    public Solicitante criarSolicitante(Solicitante solicitante) {
        return solicitanteRepository.save(solicitante);
    }

    public Solicitante atualizarSolicitante(Long id, Solicitante solicitanteAtualizado) {
        Solicitante solicitante = buscarSolicitantePorId(id);
        solicitante.setNome(solicitanteAtualizado.getNome());
        return solicitanteRepository.save(solicitante);
    }

    public void excluirSolicitante(Long id) {
        Solicitante solicitante = buscarSolicitantePorId(id);
        solicitanteRepository.delete(solicitante);
    }

    private Solicitante buscarSolicitantePorId(Long id) {
        return solicitanteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Solicitante não encontrado com o ID: " + id));
    }
}
