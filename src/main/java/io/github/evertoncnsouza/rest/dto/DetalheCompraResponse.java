package io.github.evertoncnsouza.rest.dto;

import io.github.evertoncnsouza.domain.entity.Compra;

import java.math.BigDecimal;

public class DetalheCompraResponse {

    private boolean existeCupom;
    private BigDecimal cupomAplicado;
    private PedidoResponse pedido;
    private String pais;
    private String cidade;
    private String endereco;
    private String sobrenome;
    private String nome;
    private String estado;

    public DetalheCompraResponse(Compra compra) {
        nome = compra.getNome();
        sobrenome = compra.getSobrenome();
        endereco = compra.getEndereco();
        cidade = compra.getCidade();
        pais = compra.getPais().getNome();
        //estado = compra.getEstado().getNome();
        this.pedido = new PedidoResponse(compra.getPedido());
      //cupomAplicado = compra.getCupomAplicado().getPercentualDescontoMomento();

    }

    public PedidoResponse getPedido() {
        return pedido;
    }


    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isExisteCupom() {
        return existeCupom;
    }

    public BigDecimal getCupomAplicado() {
        return cupomAplicado;
    }
}
