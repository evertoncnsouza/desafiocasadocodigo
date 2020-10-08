package io.github.evertoncnsouza.compra;

import io.github.evertoncnsouza.cupom.Cupom;
import io.github.evertoncnsouza.cupom.CupomRepository;
import io.github.evertoncnsouza.estado.Estado;
import io.github.evertoncnsouza.pais.Pais;
import io.github.evertoncnsouza.pedido.PedidoRequest;
import io.github.evertoncnsouza.pedido.Pedido;
import io.github.evertoncnsouza.validador.constraintvalidation.ExistsId;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

public class CompraRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Valid
    @NotNull
    private PedidoRequest pedido;
    //PCI 1;

    @ExistsId(domainClass = Cupom.class, fieldName = "codigo")
    private String codigoCupom;

    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome,
                         @NotBlank String sobrenome, @NotBlank String documento,
                         @NotBlank String endereco, @NotBlank String complemento,
                         @NotBlank String cidade, @NotNull Long idPais, Long idEstado,
                         @NotBlank String telefone, @NotBlank String cep, @Valid @NotNull PedidoRequest pedido) {
        super(); //Chama o construtor da classe mãe;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public PedidoRequest getPedido() {
        return pedido;
    }

    public String getDocumento() {
        return documento;
    }


    @Override
    public String toString() {
        return "CompraRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                '}';
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "você não deveria validar o documento se ele não estiver preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        //PCI 2;
        return cpfValidator.isValid(documento, null)
        || cnpjValidator.isValid(documento, null);

    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }



    //PCI 3;
         public Compra toModel(EntityManager manager, CupomRepository cupomRepository ) {
            @NotNull
            Pais pais = manager.find(Pais.class, idPais);
         //PCI 4;
         //PCI 5;
          Function<Compra, Pedido> funcaoCriacaoPedido= pedido.toModel(manager);

          //PCI 6;
            Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento,
                    pais, telefone, cep, funcaoCriacaoPedido);

          //PCI 7;
             if (idEstado != null) {
                compra.setEstado(manager.find(Estado.class, idEstado));
             }
          //PCI 8;
           if(StringUtils.hasText(codigoCupom)){
                Cupom cupom = cupomRepository.getByCodigo(codigoCupom);
                compra.aplicaCupom(cupom);

            }
            return compra;

        }
        public boolean temEstado(){
            return idEstado !=null;
        }

        public Optional<String> getCodigoCupom() {
            return Optional.ofNullable(codigoCupom);
        }
            }
