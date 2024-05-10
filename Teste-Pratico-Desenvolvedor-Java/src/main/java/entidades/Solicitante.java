package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Anotação da entidade JPA
@Entity
public class Solicitante {

    // Anotação de chave primária e estratégia de geração automática de ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação para restringir coluna a valores não nulos
    @Column(nullable = false)
    private String nome;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para depuração e registro
    @Override
    public String toString() {
        return "Solicitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    // Método equals para comparação de objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solicitante that = (Solicitante) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    // Método hashCode para uso eficaz em coleções como HashMap ou HashSet
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
