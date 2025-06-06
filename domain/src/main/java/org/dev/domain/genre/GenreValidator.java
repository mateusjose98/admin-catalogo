package org.dev.domain.genre;

import org.dev.domain.validation.Problem;
import org.dev.domain.validation.ValidationHandler;
import org.dev.domain.validation.Validator;

public class GenreValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 1;

    private final Genre genre;

    protected GenreValidator(final Genre aGenre, final ValidationHandler aHandler) {
        super(aHandler);
        this.genre = aGenre;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.genre.getName();
        if (name == null) {
            this.validationHandler().append(new Problem("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Problem("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Problem("'name' must be between 1 and 255 characters"));
        }
    }
}
