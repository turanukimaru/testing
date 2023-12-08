package com.example.testing.repo;

import com.example.testing.entity.Child;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ChildRepositoryTest {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    EntityManager entityManager;//flyway 入れなきゃ駄目か…あーそーいや結合テストがDBに接続できないのもこれか？

    @Test
    void findByDummyId() {
        List<Child> children = childRepository.findByDummyId(1L);
        System.out.println(children);
        assertThat(children.size()).isEqualTo(0);
    }
}