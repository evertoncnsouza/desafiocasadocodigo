package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Autor;
import io.github.evertoncnsouza.rest.request.AutorRequest;
import io.github.evertoncnsouza.rest.validador.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("api/autors")
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EmailValidator emailvalidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailvalidator);
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
        public String save (@RequestBody @Valid AutorRequest request){
            Autor autor = request.toModel();
            manager.persist(autor);
            return autor.toString();
     }

}
