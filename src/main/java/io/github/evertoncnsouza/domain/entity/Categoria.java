package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{nome.categoria.obrigatório}")
    @Column(unique = true)
    private String nome;

    public Categoria(@NotEmpty(message = "{nome.categoria.obrigatório}") String nome)
    {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
