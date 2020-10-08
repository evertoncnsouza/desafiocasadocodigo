package io.github.evertoncnsouza.pedido;

import io.github.evertoncnsouza.livro.Livro;
import io.github.evertoncnsouza.validador.constraintvalidation.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


public class PedidoItemRequest {

    @NotNull
    @ExistsId(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;

    @Positive
    private int quantidade;

    public PedidoItemRequest(@NotNull Long idLivro, @Positive int quantidade) {
        super();
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;

    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

    public ItemPedido toModel(EntityManager manager) {
        Livro livro = manager.find(Livro.class, idLivro);
        return new ItemPedido(livro, quantidade);
    }
}


