package io.github.evertoncnsouza.cupom;

import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository
        extends org.springframework.data.repository.Repository <Cupom, Long> {
//Esté Repository recebe dois tipos parametrizados, a Classe e o tipo do identifcador da classe;
        public Cupom getByCodigo(String codigo);
    //Método para trabalhar na classe CupomValidoValidator

}
