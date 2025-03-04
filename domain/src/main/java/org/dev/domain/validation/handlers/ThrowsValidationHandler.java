package org.dev.domain.validation.handlers;

import org.dev.domain.exception.DomainException;
import org.dev.domain.validation.Problem;
import org.dev.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(final Problem problem) {
        throw DomainException.with(problem);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getProblems());
    }

    @Override
    public <T> T validate(final Validation<T> aValidation) {
        try {
            return aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Problem(ex.getMessage()));
        }
    }

    @Override
    public List<Problem> getProblems() {
        return List.of();
    }
}