package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrors>
    handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        Collection<String> mensagens = new ArrayList<>();

        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {

            String message = String.format("Campo %s %s", fieldError.getField(),
                    fieldError.getDefaultMessage());

            mensagens.add(message);

        });

        ApiErrors apiErrors = new ApiErrors(mensagens);

        return ResponseEntity.status(HttpStatus.MULTI_STATUS.BAD_REQUEST).body(apiErrors);

    }

}
/*throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
*
* Caso for utilizar essa abordagem, tenta ao máximo utilizar na camada do controller, como por exemplo o código abaixo:
@GetMapping("/proposta/{id}")
public Proposta getProposta(@PathVariable("id") String id) {
    try {
        return propostaService.get(id);
    } catch (PropostaNotFoundException propostaNotFoundException) {
        throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Proposta não encontrada!", propostaNotFoundException);
    }
*/
