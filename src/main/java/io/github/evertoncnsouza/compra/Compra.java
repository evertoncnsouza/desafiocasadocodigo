package io.github.evertoncnsouza.compra;

import io.github.evertoncnsouza.cupom.Cupom;
import io.github.evertoncnsouza.cupom.CupomAplicado;
import io.github.evertoncnsouza.estado.Estado;
import io.github.evertoncnsouza.pais.Pais;
import io.github.evertoncnsouza.pedido.Pedido;
import org.springframework.util.Assert;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String cidade;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @ManyToOne //Uma compra tem um país. Um país, tem muitas compras;
    @NotNull
    Pais pais;
    //PCI 1;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @ManyToOne
    private Estado estado;
    //PCI 2;

   @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST) //Salva o filho quando salva a classe mãe;
    private Pedido pedido;
   //PCI 3;

   @Embedded //Faz de um objeto um componente. Usada para embutir um tipo, em outra entidade.
    private CupomAplicado cupomAplicado;
   //PCI 4;

    public Compra(@NotBlank @Email String email, @NotBlank String nome,
                  @NotBlank String sobrenome, @NotBlank String documento,
                  @NotBlank String endereco, @NotBlank String complemento,
                  @NotNull Pais pais, @NotBlank String telefone,
                  @NotBlank String cep, Function<Compra, Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais=" + pais +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", pedido=" + pedido +
               ", cupomAplicado=" + cupomAplicado +
                '}';
    }

    public void setEstado(@NotNull @Valid Estado estado) {
        Assert.notNull(pais, "Nao associe estado com pais nulo");
        Assert.isTrue(estado.pertenceAPais(pais), "Este estado não é do país associado");
        this.estado = estado;
    }

    public void aplicaCupom(Cupom cupom) {
        Assert.isTrue(cupom.valido(), "Cupom não está mais valido");
        Assert.isNull(cupomAplicado, "Você não pode trocar o cupom e uma compra");
        this.cupomAplicado = new CupomAplicado(cupom);
    }
}
