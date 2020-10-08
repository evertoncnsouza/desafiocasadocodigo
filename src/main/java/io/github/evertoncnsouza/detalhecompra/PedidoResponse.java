package io.github.evertoncnsouza.detalhecompra;

import io.github.evertoncnsouza.pedido.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoResponse {


    private List<PedidoItemResponse> itens = new ArrayList<>();

    public PedidoResponse(Pedido pedido){
        pedido.getItens().forEach(item -> itens.add(new PedidoItemResponse(item)));
    }

    public List<PedidoItemResponse> getItens() {
        return itens;
    }
}
