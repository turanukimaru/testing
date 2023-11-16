package com.example.webclienttesting.application

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.ApplicationContext
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties =["spring.profiles.active = test"]) //application-test.yml を読み込むことが出来る。
class GreetingControllerTest {
    lateinit var client: WebTestClient
    lateinit var conn: WebTestConn

    @LocalServerPort
    val port = 0

    @BeforeEach
    fun setUp(context: ApplicationContext) {
        client = WebTestClient.bindToController().build()
        conn = WebTestConn(port)
    }

    @Test
    fun hello() {
        val response = client.get().uri(conn.uri()+"/hello").exchange().expectStatus().isOk.expectBody().returnResult()
        println(response.responseBody)
    }

}