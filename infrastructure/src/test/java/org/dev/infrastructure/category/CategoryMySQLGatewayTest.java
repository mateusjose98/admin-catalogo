package org.dev.infrastructure.category;

import org.dev.infrastructure.MySQLGatewayTest;
import org.dev.infrastructure.category.persistence.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@MySQLGatewayTest
public class CategoryMySQLGatewayTest {

    @Autowired
    private CategoryMySQLGateway categoryMySQLGateway;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(categoryMySQLGateway);
        Assertions.assertNotNull(categoryRepository);

    }


}
