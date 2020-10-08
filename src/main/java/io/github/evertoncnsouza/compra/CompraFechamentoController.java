package io.github.evertoncnsouza.compra;

import io.github.evertoncnsouza.cupom.CupomRepository;
import io.github.evertoncnsouza.cupom.CupomValidoValidator;
import io.github.evertoncnsouza.validador.constraintvalidation.EstadoPertenceAPaisValidator;
import io.github.evertoncnsouza.validador.constraintvalidation.VerificaDocumentoCpfCnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("api/compras")
public class CompraFechamentoController {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
    //PCI 1;

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CupomRepository cupomRepository;
    //PCI 2;

    @Autowired
    private CupomValidoValidator cupomValidoValidator;
    //PCI 3;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerificaDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator,
                cupomValidoValidator);
    }
    //PCI 4 e PCI 5;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar status 200;
     public String save (@RequestBody @Valid CompraRequest request) { //PCI 6;
        Compra compra = request.toModel(manager, cupomRepository); //PCI 7;
       manager.persist(compra);
        return compra.toString();
            }
}
