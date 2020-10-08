package io.github.evertoncnsouza.pais;

import io.github.evertoncnsouza.pais.Pais;
import io.github.evertoncnsouza.pais.PaisRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("api/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    public String save (@RequestBody @Valid PaisRequest request) {
        Pais pais = new Pais(request.getNome());
        manager.persist(pais);
        return pais.toString();
    }
}
