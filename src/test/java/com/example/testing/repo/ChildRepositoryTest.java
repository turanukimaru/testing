package com.example.testing.repo;

import com.example.testing.entity.Child;
import jakarta.persistence.EntityManager;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ChildRepositoryTest {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    EntityManager entityManager;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String user;
    @Value("${spring.datasource.password}")
    String pass;

    @BeforeEach
    public void setUp() {
        Flyway flyway = Flyway.configure().dataSource(url, user, pass).load();
        flyway.migrate();
    }

    @Test
    void findByDummyId() {
        List<Child> children = childRepository.findByDummyId(Integer.MAX_VALUE + 1L);
        System.out.println(children);
        assertThat(children.size()).isEqualTo(0);
    }
}