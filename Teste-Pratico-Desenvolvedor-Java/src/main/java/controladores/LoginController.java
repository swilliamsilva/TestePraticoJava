package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import servicos.UserService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login.xhtml")
    public String mostrarLoginFormulario() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String usuario, @RequestParam String senha, HttpSession session, RedirectAttributes redirectAttrs) {
        boolean sucesso = userService.authenticate(usuario, senha);
        if (sucesso) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/menu.xhtml";
        } else {
            redirectAttrs.addFlashAttribute("messages", Arrays.asList("Login falhou. Tente novamente."));
            return "redirect:/login.xhtml";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("usuarioLogado");
        return "redirect:/login.xhtml";
    }

    @GetMapping("/recuperar-senha")
    public String mostrarRecuperarSenha() {
        return "recuperar-senha";
    }
}
