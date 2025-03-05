package org.dev.application.category.create;

import io.vavr.control.Either;
import org.dev.application.UseCase;
import org.dev.domain.validation.handlers.Notification;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
