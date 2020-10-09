package io.github.evertoncnsouza.domain.entity;

import org.springframework.util.Assert;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//3 PCI's
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private @NotNull @Valid Compra compra;
    //PCI 1;

    private BigDecimal total;

    //PCI 2;
    @ElementCollection //Mostra que a existência da Classe filha "ItemPedido", não tem sentido sem a classe mãe "Pedido";
    private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(@NotNull @Valid Compra compra,
                  @Size(min = 1) Set<ItemPedido> itens) {
        Assert.isTrue(!itens.isEmpty(),
                "todo pedido deve ter pelo menos um item");
        this.compra = compra;
        this.itens.addAll(itens);
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    //PCI 3;
    public boolean totalIgual(@Positive @NotNull BigDecimal total) {
        BigDecimal totalPedido = itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
                BigDecimal::add);

        return totalPedido.doubleValue() == total.doubleValue();
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "itens=" + itens +
                '}';
    }
}