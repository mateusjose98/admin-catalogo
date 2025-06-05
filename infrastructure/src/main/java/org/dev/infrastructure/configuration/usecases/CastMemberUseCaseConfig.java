package org.dev.infrastructure.configuration.usecases;

import org.dev.application.castmember.create.CreateCastMemberUseCase;
import org.dev.application.castmember.create.DefaultCreateCastMemberUseCase;
import org.dev.application.castmember.delete.DefaultDeleteCastMemberUseCase;
import org.dev.application.castmember.delete.DeleteCastMemberUseCase;
import org.dev.application.castmember.retrieve.get.DefaultGetCastMemberByIdUseCase;
import org.dev.application.castmember.retrieve.get.GetCastMemberByIdUseCase;
import org.dev.application.castmember.retrieve.list.DefaultListCastMembersUseCase;
import org.dev.application.castmember.retrieve.list.ListCastMembersUseCase;
import org.dev.application.castmember.update.DefaultUpdateCastMemberUseCase;
import org.dev.application.castmember.update.UpdateCastMemberUseCase;
import org.dev.domain.castmember.CastMemberGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class CastMemberUseCaseConfig {

    private final CastMemberGateway castMemberGateway;

    public CastMemberUseCaseConfig(final CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Bean
    public CreateCastMemberUseCase createCastMemberUseCase() {
        return new DefaultCreateCastMemberUseCase(castMemberGateway);
    }

    @Bean
    public DeleteCastMemberUseCase deleteCastMemberUseCase() {
        return new DefaultDeleteCastMemberUseCase(castMemberGateway);
    }

    @Bean
    public GetCastMemberByIdUseCase getCastMemberByIdUseCase() {
        return new DefaultGetCastMemberByIdUseCase(castMemberGateway);
    }

    @Bean
    public ListCastMembersUseCase listCastMembersUseCase() {
        return new DefaultListCastMembersUseCase(castMemberGateway);
    }

    @Bean
    public UpdateCastMemberUseCase updateCastMemberUseCase() {
        return new DefaultUpdateCastMemberUseCase(castMemberGateway);
    }
}
