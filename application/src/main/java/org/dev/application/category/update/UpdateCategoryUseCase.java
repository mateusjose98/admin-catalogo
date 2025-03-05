package org.dev.application.category.update;

import io.vavr.control.Either;
import org.dev.application.UseCase;
import org.dev.domain.validation.handlers.Notification;

public abstract class UpdateCategoryUseCase
        extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
