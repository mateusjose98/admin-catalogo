package org.dev.infrastructure.configuration.usecases;

import org.dev.application.genre.create.CreateGenreUseCase;
import org.dev.application.genre.create.DefaultCreateGenreUseCase;
import org.dev.application.genre.delete.DefaultDeleteGenreUseCase;
import org.dev.application.genre.delete.DeleteGenreUseCase;
import org.dev.application.genre.retrieve.get.DefaultGetGenreByIdUseCase;
import org.dev.application.genre.retrieve.get.GetGenreByIdUseCase;
import org.dev.application.genre.retrieve.list.DefaultListGenreUseCase;
import org.dev.application.genre.retrieve.list.ListGenreUseCase;
import org.dev.application.genre.update.DefaultUpdateGenreUseCase;
import org.dev.application.genre.update.UpdateGenreUseCase;
import org.dev.domain.category.CategoryGateway;
import org.dev.domain.genre.GenreGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class GenreUseCaseConfig {

    private final CategoryGateway categoryGateway;
    private final GenreGateway genreGateway;

    public GenreUseCaseConfig(
            final CategoryGateway categoryGateway,
            final GenreGateway genreGateway
    ) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Bean
    public CreateGenreUseCase createGenreUseCase() {
        return new DefaultCreateGenreUseCase(categoryGateway, genreGateway);
    }

    @Bean
    public DeleteGenreUseCase deleteGenreUseCase() {
        return new DefaultDeleteGenreUseCase(genreGateway);
    }

    @Bean
    public GetGenreByIdUseCase getGenreByIdUseCase() {
        return new DefaultGetGenreByIdUseCase(genreGateway);
    }

    @Bean
    public ListGenreUseCase listGenreUseCase() {
        return new DefaultListGenreUseCase(genreGateway);
    }

    @Bean
    public UpdateGenreUseCase updateGenreUseCase() {
        return new DefaultUpdateGenreUseCase(categoryGateway, genreGateway);
    }
}
