package io.github.evertoncnsouza.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("api/estados")

public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) Comentado para retornar 200;
    @Transactional
    public String save(@RequestBody @Valid EstadoRequest request){
        Estado estado = request.toModel(manager);
        manager.persist(estado);
        return estado.toString();
    }

}
