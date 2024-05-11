package beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class AgendamentoBean {

    private LocalDate data;
    private LocalTime hora;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    // Método para salvar o agendamento
    public String salvar() {
        // Implemente a lógica para salvar o agendamento no banco de dados aqui
        return "sucesso"; // Redireciona para uma página de sucesso após salvar
    }
}
