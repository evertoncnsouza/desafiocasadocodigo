package io.github.evertoncnsouza.categoria;

import io.github.evertoncnsouza.validador.constraintvalidation.UniqueValue;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

//Não tem PCI
public class CategoriaRequest {

    @NotEmpty(message = "{nome.categoria.obrigatorio}")
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


