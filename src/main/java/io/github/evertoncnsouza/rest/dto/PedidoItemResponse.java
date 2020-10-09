package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.ItemPedido;

import java.math.BigDecimal;

public class PedidoItemResponse {
    private int quantidade;
    private BigDecimal preco;
    private itemLivroDetalheResponse livro;

    public PedidoItemResponse(ItemPedido item) {
        livro = new itemLivroDetalheResponse(item.getLivro());
        preco = item.getPrecoMomento();
        quantidade = item.getQuantidade();

    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public itemLivroDetalheResponse getLivro() {
        return livro;
    }
}