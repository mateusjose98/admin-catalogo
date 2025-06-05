package org.dev.infrastructure.castmember.presenter;


import org.dev.application.castmember.retrieve.get.CastMemberOutput;
import org.dev.application.castmember.retrieve.list.CastMemberListOutput;
import org.dev.infrastructure.castmember.models.CastMemberListResponse;
import org.dev.infrastructure.castmember.models.CastMemberResponse;

public interface CastMemberPresenter {

    static CastMemberResponse present(final CastMemberOutput aMember) {
        return new CastMemberResponse(
                aMember.id(),
                aMember.name(),
                aMember.type().name(),
                aMember.createdAt().toString(),
                aMember.updatedAt().toString()
        );
    }

    static CastMemberListResponse present(final CastMemberListOutput aMember) {
        return new CastMemberListResponse(
                aMember.id(),
                aMember.name(),
                aMember.type().name(),
                aMember.createdAt().toString()
        );
    }
}
