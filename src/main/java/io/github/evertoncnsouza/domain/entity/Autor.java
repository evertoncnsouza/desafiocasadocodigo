package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table (name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{email.invalido}")
    private String email;

    @Size (max = 400, message = "{limite.maximo.400}")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    private LocalDateTime horaCriacao = LocalDateTime.now();
    @NotNull

    @Deprecated
    public Autor(String email) {
    }

    public Autor(@NotEmpty(message = "{campo.nome.obrigatorio}") String nome,
                 @NotEmpty(message = "{campo.email.obrigatorio}") @Email(message = "Email invalido") String email,
                 @NotEmpty(message = "{campo.descricao.obrigatoria}") String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", horaCriacao=" + horaCriacao +
                '}';
    }


}


