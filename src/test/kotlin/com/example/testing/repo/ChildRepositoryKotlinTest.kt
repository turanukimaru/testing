package com.example.testing.repo

import jakarta.persistence.EntityManager
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ChildRepositoryKotlinTest {
    @Autowired
    var childRepository: ChildRepository? = null

    @Autowired
    var entityManager: EntityManager? = null

    @Test
    fun findByDummyId() {
        val children = childRepository!!.findByDummyId(1L)
        println(children)
        AssertionsForClassTypes.assertThat(children.size).isEqualTo(0)
    }

}