package controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entidades.Agendamento;
import servicos.AgendamentoService;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/agendamentos")
    public String listarAgendamentos(
            @RequestParam(required = false) LocalDate inicio,
            @RequestParam(required = false) LocalDate fim,
            Model model) {

        // Se as datas não forem fornecidas, defina padrões
        if (inicio == null) {
            inicio = LocalDate.now();
        }
        if (fim == null) {
            fim = LocalDate.now().plusDays(7);
        }

        // Verifique se a data de início é retroativa
        if (inicio.isBefore(LocalDate.now())) {
            model.addAttribute("erro", "A data de início não pode ser retroativa. Por favor, corrija a data.");
            return "erro";
        }

        // Obtenha os agendamentos entre as datas fornecidas
        List<Agendamento> agendamentos = agendamentoService.buscarAgendamentos(inicio, fim);
        int totalVagas = agendamentoService.calcularTotalVagas(inicio, fim);
        int totalAgendamentos = agendamentos.size();

        // Verifique se há vagas suficientes para o período
        if (totalAgendamentos >= totalVagas) {
            model.addAttribute("erro", "Não há vagas disponíveis para o período informado. Por favor, escolha outro período.");
            return "erro";
        }

        model.addAttribute("agendamentos", agendamentos);
        model.addAttribute("mensagem", "Há vagas disponíveis para o período informado.");

        return "agendamentos";
    }
}
