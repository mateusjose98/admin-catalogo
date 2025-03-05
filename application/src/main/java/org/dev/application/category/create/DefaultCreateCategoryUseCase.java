package org.dev.application.category.create;

import io.vavr.control.Either;
import org.dev.domain.category.Category;
import org.dev.domain.category.CategoryGateway;
import org.dev.domain.validation.handlers.Notification;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {
        final var notification = Notification.create();
        final var aCategory = Category.newCategory(aCommand.name(), aCommand.description(),  aCommand.isActive());
        aCategory.validate(notification);

        return notification.hasProblem() ? Left(notification) : create(aCategory);
    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory) {
        return Try(() -> this.categoryGateway.create(aCategory))
                .toEither()
                .bimap(Notification::create, CreateCategoryOutput::from);
    }
}