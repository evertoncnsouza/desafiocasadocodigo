package io.github.evertoncnsouza.rest.validador;

import io.github.evertoncnsouza.domain.entity.Autor;
import io.github.evertoncnsouza.repository.Autors;
import io.github.evertoncnsouza.rest.request.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;


@Component
public class EmailValidator implements Validator {

   @Autowired
    private Autors autors;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AutorRequest request = (AutorRequest) target;
        Optional<Autor> possivelAutor = autors.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o email cadastrado "
                            + request.getEmail());
        }
    }
}

