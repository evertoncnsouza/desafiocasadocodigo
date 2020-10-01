package io.github.evertoncnsouza.rest;

import java.util.Collection;

public class ApiErrors {

    private Collection<String> errors;

    public ApiErrors(Collection<String> errors) {
        this.errors = errors;
    }

    public Collection<String> getErrors() {
        return errors;
    }

    public void setErrors(Collection<String> errors) {
        this.errors = errors;
    }
}
