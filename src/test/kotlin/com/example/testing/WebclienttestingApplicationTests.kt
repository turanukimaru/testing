package com.example.testing

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@TestPropertySource(properties = ["spring.profiles.active = test"])
class WebclienttestingApplicationTests {

    @Test
    fun contextLoads() {
    }

}
