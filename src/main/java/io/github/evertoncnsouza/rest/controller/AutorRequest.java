package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Autor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
    private String email;

    @Size(max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatoria}")
    private String descricao;

    public AutorRequest(@NotEmpty(message = "{campo.nome.obrigatorio}")
    String nome, @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
    String email, @Size(max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}") String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    public String getEmail() {
        return this.email;
    }

}
