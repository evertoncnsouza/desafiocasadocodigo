package io.github.evertoncnsouza.rest.request;

import io.github.evertoncnsouza.domain.entity.Categoria;
import io.github.evertoncnsouza.rest.validador.constraintvalidation.UniqueValue;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class CategoriaRequest {

    @NotEmpty(message = "{nome.categoria.obrigatório}")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    @Column(unique = true)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;

    }
}

