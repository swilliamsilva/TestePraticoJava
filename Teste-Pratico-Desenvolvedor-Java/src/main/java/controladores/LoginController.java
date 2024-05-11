package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import servicos.UserService;
import java.util.Arrays;

@Controller
public class LoginController {

    @Autowired
    private UserService userService; // Injeção do UserService

    @GetMapping("/login")
    public String mostrarLoginFormulario() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String usuario, @RequestParam String senha, RedirectAttributes redirectAttrs) {
        boolean sucesso = userService.authenticate(usuario, senha);
        if (sucesso) {
            return "redirect:/pagina-principal";
        } else {
            redirectAttrs.addFlashAttribute("messages", Arrays.asList("Login falhou. Tente novamente."));
            return "redirect:/login";
        }
    }

    @GetMapping("/recuperar-senha")
    public String mostrarRecuperarSenha() {
        return "recuperar-senha";
    }
}
