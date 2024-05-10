package controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

        if (inicio == null) {
            inicio = LocalDate.now();
        }

        if (fim == null) {
            fim = LocalDate.now().plusDays(7);
        }
		return null;

  //      List<Agendamento> agendamentos = agendamentoService.buscarAgendamentos(inicio, fim);
 //       model.addAttribute("agendamentos", agendamentos);

  //      return "agendamentos";
    }

    @PostMapping("/agendamento")
    public String criarAgendamento(@RequestBody Agendamento agendamento, Model model) {
        agendamentoService.criarAgendamento(agendamento);
        model.addAttribute("mensagem", "Agendamento criado com sucesso!");
        return "resultado";
    }
}
