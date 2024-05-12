package beans;

import java.time.LocalDate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class AgendamentoBean {

    private LocalDate data;
    private String hora;

    // Getters e setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
