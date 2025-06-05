package org.dev.infrastructure.castmember.models;


import org.dev.domain.castmember.CastMemberType;

public record CreateCastMemberRequest(String name, CastMemberType type) {
}
