package servicos;

import java.util.List;

//VagaService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Vaga;
import repositorios.VagaRepository;

@Service
public class VagaService {
 @Autowired
 private VagaRepository vagaRepository;

 public List<Vaga> listarTodos() {
     return vagaRepository.findAll();
 }

 public Vaga buscarPorId(Long id) {
     return vagaRepository.findById(id).orElse(null);
 }

 public Vaga salvar(Vaga vaga) {
     return vagaRepository.save(vaga);
 }

 public void deletar(Long id) {
     vagaRepository.deleteById(id);
 }
}
