package org.dev.domain.category;

import org.dev.domain.validation.Problem;
import org.dev.domain.validation.ValidationHandler;
import org.dev.domain.validation.Validator;

public class CategoryValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();
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
            this.validationHandler().append(new Problem("'name' must be between 3 and 255 characters"));
        }
    }
}
