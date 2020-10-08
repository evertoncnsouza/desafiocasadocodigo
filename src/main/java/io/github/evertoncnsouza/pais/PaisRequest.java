package io.github.evertoncnsouza.pais;

import io.github.evertoncnsouza.validador.constraintvalidation.UniqueValue;
import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
