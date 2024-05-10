package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entidades.Vaga;
import servicos.VagaService;

@Named
@ViewScoped
@Component
public class VagaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Vaga vaga = new Vaga();
    private List<Vaga> vagas;

    @Autowired
    private VagaService vagaService;

    public void init() {
        vagas = vagaService.listarTodos();
    }

    public void salvar() {
        vagaService.salvar(vaga);
        vaga = new Vaga(); // Limpa os campos após salvar
        init(); // Recarrega a lista de vagas
    }

    public void deletar(Long id) {
        vagaService.deletar(id);
        init(); // Recarrega a lista de vagas
    }
}

   
