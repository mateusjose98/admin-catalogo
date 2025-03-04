package org.dev.domain.exception;

import org.dev.domain.AggregateRoot;
import org.dev.domain.Identifier;
import org.dev.domain.validation.Problem;

import java.util.Collections;
import java.util.List;

public class NotFoundException extends DomainException {

    protected NotFoundException(final String aMessage, final List<Problem> anProblems) {
        super(aMessage, anProblems);
    }

    public static NotFoundException with(
            final Class<? extends AggregateRoot<?>> anAggregate,
            final Identifier id
    ) {
        final var anError = "%s with ID %s was not found".formatted(
                anAggregate.getSimpleName(),
                id.getValue()
        );
        return new NotFoundException(anError, Collections.emptyList());
    }

    public static NotFoundException with(final Problem problem) {
        return new NotFoundException(problem.message(), List.of(problem));
    }
}
