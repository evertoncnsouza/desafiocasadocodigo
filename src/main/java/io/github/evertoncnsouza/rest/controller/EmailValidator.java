/*package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.domain.entity.Autor;
import io.github.evertoncnsouza.repository.Autors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.Validator;
import java.util.Optional;

@Component
public class EmailValidator implements Validator {

    @Autowired
    private Autors autors;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutor.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoAutor request = (NovoAutor) target;

        Optional<Autor> possivelAutor = autors.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe email cadastrado" + request.getEmail());
        }
    }


}*/