package io.github.evertoncnsouza.repository;

import io.github.evertoncnsouza.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Autors extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}