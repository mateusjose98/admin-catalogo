package org.dev.application.genre.create;


import org.dev.domain.category.CategoryGateway;
import org.dev.domain.category.CategoryID;
import org.dev.domain.exception.NotificationException;
import org.dev.domain.genre.Genre;
import org.dev.domain.genre.GenreGateway;
import org.dev.domain.validation.Problem;
import org.dev.domain.validation.ValidationHandler;
import org.dev.domain.validation.handlers.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultCreateGenreUseCase extends CreateGenreUseCase {

    private final CategoryGateway categoryGateway;
    private final org.dev.domain.genre.GenreGateway genreGateway;

    public DefaultCreateGenreUseCase(
            final CategoryGateway categoryGateway,
            final GenreGateway genreGateway
    ) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Override
    public CreateGenreOutput execute(final CreateGenreCommand aCommand) {
        final var aName = aCommand.name();
        final var isActive = aCommand.isActive();
        final var categories = toCategoryID(aCommand.categories());

        final var notification = Notification.create();
        notification.append(validateCategories(categories));

        final var aGenre = notification.validate(() -> Genre.newGenre(aName, isActive));

        if (notification.hasProblem()) {
            throw new NotificationException("Could not create Aggregate Genre", notification);
        }

        aGenre.addCategories(categories);

        return CreateGenreOutput.from(this.genreGateway.create(aGenre));
    }

    private ValidationHandler validateCategories(final List<CategoryID> ids) {
        final var notification = Notification.create();
        if (ids == null || ids.isEmpty()) {
            return notification;
        }

        final var retrievedIds = categoryGateway.existsByIds(ids);

        if (ids.size() != retrievedIds.size()) {
            final var missingIds = new ArrayList<>(ids);
            missingIds.removeAll(retrievedIds);

            final var missingIdsMessage = missingIds.stream()
                    .map(CategoryID::getValue)
                    .collect(Collectors.joining(", "));

            notification.append(new Problem("Some categories could not be found: %s".formatted(missingIdsMessage)));
        }

        return notification;
    }

    private List<CategoryID> toCategoryID(final List<String> categories) {
        return categories.stream()
                .map(CategoryID::from)
                .toList();
    }
}
