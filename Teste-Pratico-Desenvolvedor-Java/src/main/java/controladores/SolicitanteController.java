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
    
    // Exemplo de serviço ou repositório injetado via @Autowired
    private final SolicitanteService solicitanteService;

    public SolicitanteController(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    // Endpoint para obter todos os solicitantes
    @GetMapping
    public List<Solicitante> listarTodos() {
        return solicitanteService.listarTodos();
    }

    // Endpoint para obter um solicitante específico por ID
    @GetMapping("/{id}")
    public Optional<Solicitante> obterPorId(@PathVariable Long id) {
        return solicitanteService.obterPorId(id);
    }

    // Endpoint para criar um novo solicitante
    @PostMapping
    public Solicitante criarSolicitante(@RequestBody Solicitante solicitante) {
        return solicitanteService.criarSolicitante(solicitante);
    }

    // Endpoint para atualizar um solicitante existente
    @PutMapping("/{id}")
    public Solicitante atualizarSolicitante(@PathVariable Long id, @RequestBody Solicitante solicitante) {
        return solicitanteService.atualizarSolicitante(id, solicitante);
    }

    // Endpoint para excluir um solicitante por ID
    @DeleteMapping("/{id}")
    public void excluirSolicitante(@PathVariable Long id) {
        solicitanteService.excluirSolicitante(id);
    }
}
