package org.dev.application.castmember.retrieve.list;


import org.dev.application.UseCase;
import org.dev.domain.pagination.Pagination;
import org.dev.domain.pagination.SearchQuery;

public sealed abstract class ListCastMembersUseCase
        extends UseCase<SearchQuery, Pagination<CastMemberListOutput>>
        permits DefaultListCastMembersUseCase {
}
