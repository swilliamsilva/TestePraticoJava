import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Solicitante;
import servicos.SolicitanteService;

@ManagedBean
@ViewScoped
public class SolicitanteBean {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String salvar() {
        SolicitanteService solicitanteService = new SolicitanteService();
        Solicitante solicitante = new Solicitante();
        solicitante.setNome(nome);
        solicitanteService.criarSolicitante(solicitante);
        return "listarSolicitantes?faces-redirect=true";
    }
}
