package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Categoria;
import io.github.evertoncnsouza.rest.request.CategoriaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public String save (@RequestBody @Valid CategoriaRequest request) {
        Categoria categoria = new Categoria(request.getNome());
        manager.persist(categoria);
        return categoria.toString();
    }
}
