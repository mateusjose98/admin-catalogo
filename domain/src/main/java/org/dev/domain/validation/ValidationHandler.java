package org.dev.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Problem anProblem);

    ValidationHandler append(ValidationHandler anHandler);

    List<Problem> getProblems();

    default boolean hasProblem() {
        return getProblems() != null && !getProblems().isEmpty();
    }

    default Problem firstProblem() {
        if (getProblems() != null && !getProblems().isEmpty()) {
            return getProblems().get(0);
        } else {
            return null;
        }
    }

    interface Validation<T> {
        T validate();
    }

    <T> T validate(Validation<T> aValidation);


}
