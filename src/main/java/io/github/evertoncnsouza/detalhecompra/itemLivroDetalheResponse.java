package io.github.evertoncnsouza.detalhecompra;

import io.github.evertoncnsouza.livro.Livro;

public class itemLivroDetalheResponse {

    private String titulo;

    private String isbn;

    public itemLivroDetalheResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }
}

