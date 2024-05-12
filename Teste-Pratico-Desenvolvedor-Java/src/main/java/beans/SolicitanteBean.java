package beans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import entidades.Solicitante;
import servicos.SolicitanteService;

@Named
@ViewScoped
public class SolicitanteBean {

    private String nome;

    @Inject
    private SolicitanteService solicitanteService;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String salvar() {
        Solicitante solicitante = new Solicitante();
        solicitante.setNome(nome);
        solicitanteService.criarSolicitante(solicitante);
        return "listarSolicitantes?faces-redirect=true";
    }
}
