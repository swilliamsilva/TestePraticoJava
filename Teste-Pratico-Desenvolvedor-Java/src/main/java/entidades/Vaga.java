package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaga {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private LocalDate inicio;
 private LocalDate fim;
 private Integer quantidade;

 // Construtores
 public Vaga() {
 }

 public Vaga(LocalDate inicio, LocalDate fim, Integer quantidade) {
     this.inicio = inicio;
     this.fim = fim;
     this.quantidade = quantidade;
 }

 // Getters e Setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public LocalDate getInicio() {
     return inicio;
 }

 public void setInicio(LocalDate inicio) {
     this.inicio = inicio;
 }

 public LocalDate getFim() {
     return fim;
 }

 public void setFim(LocalDate fim) {
     this.fim = fim;
 }

 public Integer getQuantidade() {
     return quantidade;
 }

 public void setQuantidade(Integer quantidade) {
     this.quantidade = quantidade;
 }
}
