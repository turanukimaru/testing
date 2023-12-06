package com.example.testing

import com.example.testing.app.DummyController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.ApplicationContext
import org.springframework.core.ParameterizedTypeReference
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = ["spring.profiles.active = test"])
class DummyControllerKotlinTest {
    lateinit var client: WebTestClient

    @Autowired
    lateinit var conn: WebTestConn

    @Autowired
    lateinit var contl: DummyController

    @LocalServerPort
    val port = 0

    @BeforeEach
    fun setUp(context: ApplicationContext) {
//        client = WebTestClient.bindToServer().build()
        client = WebTestClient.bindToController(contl).build()
        conn.setup(port)
    }

    @Test
    fun hello() {
        val response =
            client.get().uri(conn.uri() + "/dummy").exchange().expectStatus().isOk.expectBody<String>().returnResult()
        println("テスト完了")
        println("response.responseBody")
        println(response.responseBody)
    }
    @Test
    fun hello_json() {
            client.get().uri(conn.uri() + "/hello").exchange().expectStatus().isOk.expectBody()
                .jsonPath("\$.message").isEqualTo("hello")
    }

}