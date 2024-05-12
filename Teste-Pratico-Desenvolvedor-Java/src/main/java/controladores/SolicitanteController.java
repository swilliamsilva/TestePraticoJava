package controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidades.Solicitante;
import servicos.SolicitanteService;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {
    
    private final SolicitanteService solicitanteService;

    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    @GetMapping
    public List<Solicitante> listarTodos() {
        return solicitanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Solicitante> obterPorId(@PathVariable Long id) {
        return solicitanteService.obterPorId(id);
    }

    @PostMapping
    public Solicitante criarSolicitante(@RequestBody Solicitante solicitante) {
        return solicitanteService.criarSolicitante(solicitante);
    }

    @PutMapping("/{id}")
    public Solicitante atualizarSolicitante(@PathVariable Long id, @RequestBody Solicitante solicitante) {
        return solicitanteService.atualizarSolicitante(id, solicitante);
    }

    @DeleteMapping("/{id}")
    public void excluirSolicitante(@PathVariable Long id) {
        solicitanteService.excluirSolicitante(id);
    }
}
