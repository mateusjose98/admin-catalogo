package org.dev.application.category.retrieve.list;

import org.dev.application.UseCase;
import org.dev.domain.pagination.Pagination;
import org.dev.domain.pagination.SearchQuery;

public abstract class ListCategoriesUseCase
        extends UseCase<SearchQuery, Pagination<CategoryListOutput>> {
}
