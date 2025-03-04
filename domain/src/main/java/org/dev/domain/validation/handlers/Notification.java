package org.dev.domain.validation.handlers;

import org.dev.domain.exception.DomainException;
import org.dev.domain.validation.Problem;
import org.dev.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<Problem> problems;

    private Notification(final List<Problem> problems) {
        this.problems = problems;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Throwable t) {
        return create(new Problem(t.getMessage()));
    }

    public static Notification create(final Problem anProblem) {
        return new Notification(new ArrayList<>()).append(anProblem);
    }

    @Override
    public Notification append(final Problem anProblem) {
        this.problems.add(anProblem);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler anHandler) {
        this.problems.addAll(anHandler.getProblems());
        return this;
    }

    @Override
    public <T> T validate(final Validation<T> aValidation) {
        try {
            return aValidation.validate();
        } catch (final DomainException ex) {
            this.problems.addAll(ex.getProblems());
        } catch (final Throwable t) {
            this.problems.add(new Problem(t.getMessage()));
        }
        return null;
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
