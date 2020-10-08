package io.github.evertoncnsouza.estado;

import io.github.evertoncnsouza.pais.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


// 2 PCI's
@Entity
@Table (name = "Estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Valid @ManyToOne
    private Pais pais;
    //PCI 1;

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
//PCI 2;
    public boolean pertenceAPais(Pais pais){
        return this.pais.equals(pais);
    }
}
