package com.example.testing.repo

import com.example.testing.entity.Child
import jakarta.persistence.EntityManager
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = ["com.example.testing.entity"])
@ContextConfiguration(classes = [ChildRepository::class]) // context と entity scan を自動で設定するのってどうやるんだっけ…？
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChildRepositoryKotlinTest {
    @Autowired
    var childRepository: ChildRepository? = null

    @Autowired
    var entityManager: EntityManager? = null

    @Test
    fun findByDummyId() {
        val child = Child()
        child.dummyId = Int.MAX_VALUE - 1L
        child.name = "name"
        child.text = "text"
        entityManager!!.persist(child)
        val empty = childRepository!!.findByDummyId(1L)
        println(empty)
        AssertionsForClassTypes.assertThat(empty.size).isEqualTo(0)
        val one = childRepository!!.findByDummyId(Int.MAX_VALUE - 1L)
        println(one)
        AssertionsForClassTypes.assertThat(one.size).isEqualTo(1)
    }

}