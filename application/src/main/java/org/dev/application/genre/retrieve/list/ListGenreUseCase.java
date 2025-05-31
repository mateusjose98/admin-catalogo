package org.dev.application.genre.retrieve.list;


import org.dev.application.UseCase;
import org.dev.domain.pagination.Pagination;
import org.dev.domain.pagination.SearchQuery;

public abstract class ListGenreUseCase
        extends UseCase<SearchQuery, Pagination<GenreListOutput>> {
}
