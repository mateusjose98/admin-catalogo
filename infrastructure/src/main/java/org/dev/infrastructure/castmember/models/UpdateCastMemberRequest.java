package org.dev.infrastructure.castmember.models;


import org.dev.domain.castmember.CastMemberType;

public record UpdateCastMemberRequest(String name, CastMemberType type) {
}
