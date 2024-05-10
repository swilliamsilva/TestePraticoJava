package controladores;
import java.util.List;

//VagaController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidades.Vaga;
import servicos.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {
 @Autowired
 private VagaService vagaService;

 @GetMapping
 public ResponseEntity<List<Vaga>> listarVagas() {
     List<Vaga> vagas = vagaService.listarTodos();
     return ResponseEntity.ok(vagas);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Vaga> buscarVagaPorId(@PathVariable Long id) {
     Vaga vaga = vagaService.buscarPorId(id);
     if (vaga != null) {
         return ResponseEntity.ok(vaga);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @PostMapping
 public ResponseEntity<Vaga> criarVaga(@RequestBody Vaga vaga) {
     Vaga novaVaga = vagaService.salvar(vaga);
     return ResponseEntity.status(HttpStatus.CREATED).body(novaVaga);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
     vagaService.deletar(id);
     return ResponseEntity.noContent().build();
 }
}
