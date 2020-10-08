package io.github.evertoncnsouza.autor;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface Autors extends CrudRepository<Autor, Long> {
//Este Repository recebe dois tipos parametrizados. O nome da classe e o tipo do identificador da classe(id);
    Optional<Autor> findByEmail(String email);
    //Método para trabalhar na classe EmailValidator;
}