package org.dev.infrastructure.configuration;

import org.dev.application.category.create.CreateCategoryUseCase;
import org.dev.application.category.create.DefaultCreateCategoryUseCase;
import org.dev.application.category.delete.DefaultDeleteCategoryUseCase;
import org.dev.application.category.delete.DeleteCategoryUseCase;
import org.dev.application.category.retrieve.get.DefaultGetCategoryByIdUseCase;
import org.dev.application.category.retrieve.get.GetCategoryByIdUseCase;
import org.dev.application.category.retrieve.list.DefaultListCategoriesUseCase;
import org.dev.application.category.retrieve.list.ListCategoriesUseCase;
import org.dev.application.category.update.DefaultUpdateCategoryUseCase;
import org.dev.application.category.update.UpdateCategoryUseCase;
import org.dev.domain.category.CategoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryUseCaseConfig {

    private final CategoryGateway categoryGateway;

    public CategoryUseCaseConfig(final CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Bean
    public CreateCategoryUseCase createCategoryUseCase() {
        return new DefaultCreateCategoryUseCase(categoryGateway);
    }

    @Bean
    public UpdateCategoryUseCase updateCategoryUseCase() {
        return new DefaultUpdateCategoryUseCase(categoryGateway);
    }

    @Bean
    public GetCategoryByIdUseCase getCategoryByIdUseCase() {
        return new DefaultGetCategoryByIdUseCase(categoryGateway);
    }

    @Bean
    public ListCategoriesUseCase listCategoriesUseCase() {
        return new DefaultListCategoriesUseCase(categoryGateway);
    }

    @Bean
    public DeleteCategoryUseCase deleteCategoryUseCase() {
        return new DefaultDeleteCategoryUseCase(categoryGateway);
    }


}
