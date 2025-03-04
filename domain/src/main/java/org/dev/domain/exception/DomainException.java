package org.dev.domain.exception;

import org.dev.domain.validation.Problem;

import java.util.List;

public class DomainException extends NoStacktraceException {

    protected final List<Problem> problems;

    protected DomainException(final String aMessage, final List<Problem> problems) {
        super(aMessage);
        this.problems = problems;
    }

    public static DomainException with(final Problem anProblems) {
        return new DomainException(anProblems.message(), List.of(anProblems));
    }

    public static DomainException with(final List<Problem> anProblems) {
        return new DomainException("", anProblems);
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
