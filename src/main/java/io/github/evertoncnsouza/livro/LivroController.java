package io.github.evertoncnsouza.livro;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

//2 PCI's;
@RestController
@RequestMapping("api/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    public String save(@RequestBody @Valid LivroRequest request) {
        Livro livro = request.toModel(manager);
        manager.persist(livro);
        return livro.toString();
    }
//LivroRequest PCI 1;
//Livro PCI 2;
}
