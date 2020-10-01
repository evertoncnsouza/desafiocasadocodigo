package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Autor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/autors")
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
        public String save (@RequestBody @Valid AutorRequest request){
            Autor autor = request.toModel();
            manager.persist(autor);
            return autor.toString();
            //Request Value Objects, onde Request possui o comportamento
        //para criar um novo autor;
    }

}
