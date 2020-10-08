package io.github.evertoncnsouza.pedido;

import io.github.evertoncnsouza.compra.Compra;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//2 PCI;
public class PedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;

    @Size(min=1)
    @Valid
    private List<PedidoItemRequest> itens = new ArrayList<>();
    //PCI 1;

    public PedidoRequest(@Positive @NotNull BigDecimal total,
                         @Size(min = 1) @Valid List<PedidoItemRequest> itens) {
        super();
        this.total = total;
        this.itens = itens;
    }

    public List<PedidoItemRequest> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }

    public Function<Compra, Pedido> toModel(EntityManager manager) {
        Set<ItemPedido> itensCalculados = itens.stream().map(item -> item.toModel(manager))
                .collect(Collectors.toSet());
        //PCI 2;

        return(compra) -> {
            Pedido pedido = new Pedido(compra, itensCalculados);
            Assert.isTrue(pedido.totalIgual(total),"Olha, o total enviado, não corresponde ao total real");
            return pedido;
        };
    }
}

