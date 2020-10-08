package io.github.evertoncnsouza.detalhelivro;

import io.github.evertoncnsouza.autor.Autor;


//Não serializamos objetos de domínio para reposta de API;
public class DetalheSiteAutorResponse {

    private String nome;
    private String descricao;

  //PCI 1;
    public DetalheSiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
