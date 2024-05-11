package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entidades.Solicitante;
import servicos.SolicitanteService;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class SolicitanteBean {

    private String nome;

    // Injetando SolicitanteService via ManagedProperty
    @ManagedProperty("#{solicitanteService}")
    private SolicitanteService solicitanteService;

    // Getter e Setter para SolicitanteService
    public SolicitanteService getSolicitanteService() {
        return solicitanteService;
    }

    public void setSolicitanteService(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

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
