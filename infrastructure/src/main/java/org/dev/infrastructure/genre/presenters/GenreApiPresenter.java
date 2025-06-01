package org.dev.infrastructure.genre.presenters;


import org.dev.application.genre.retrieve.get.GenreOutput;
import org.dev.application.genre.retrieve.list.GenreListOutput;
import org.dev.infrastructure.genre.models.GenreListResponse;
import org.dev.infrastructure.genre.models.GenreResponse;

public interface GenreApiPresenter {

    static GenreResponse present(final GenreOutput output) {
        return new GenreResponse(
                output.id(),
                output.name(),
                output.categories(),
                output.isActive(),
                output.createdAt(),
                output.updatedAt(),
                output.deletedAt()
        );
    }

    static GenreListResponse present(final GenreListOutput output) {
        return new GenreListResponse(
                output.id(),
                output.name(),
                output.isActive(),
                output.createdAt(),
                output.deletedAt()
        );
    }
}
