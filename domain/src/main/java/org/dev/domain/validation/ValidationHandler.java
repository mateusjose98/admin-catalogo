package org.dev.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Problem anProblem);

    ValidationHandler append(ValidationHandler anHandler);

    <T> T validate(Validation<T> aValidation);

    List<Problem> getProblems();

    default boolean hasProblem() {
        return getProblems() != null && !getProblems().isEmpty();
    }

    default Problem firstProblem() {
        if (getProblems() != null && !getProblems().isEmpty()) {
            return getProblems().getFirst();
        } else {
            return null;
        }
    }

    interface Validation<T> {
        T validate();
    }
}
