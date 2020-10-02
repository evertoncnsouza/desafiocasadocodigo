package io.github.evertoncnsouza.rest;

import java.util.List;

public class ApiErrors {

    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;

    }
}
