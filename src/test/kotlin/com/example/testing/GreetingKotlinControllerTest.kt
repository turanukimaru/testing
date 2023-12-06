package com.example.testing

import com.example.testing.app.GreetingKotlinController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.ApplicationContext
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = ["spring.profiles.active = test"]) //application-test.yml を読み込むことが出来る。
class GreetingKotlinControllerTest {
    lateinit var client: WebTestClient // 初期化コードがいるので late

    @Autowired
    lateinit var conn: WebTestConn //Component.Autowired にして環境変数を読めるようにする。ローカル用ポートは別に初期化が必要

    @Autowired
    lateinit var contl: GreetingKotlinController // bindToController するときはこれでServiceとかをインジェクションする。…できるはずだよな？

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
            client.get().uri(conn.uri() + "/hello").exchange().expectStatus().isOk.expectBody().returnResult()
        println(response.responseBody)
    }
    @Test
    fun hello_json() {
            client.get().uri(conn.uri() + "/hello").exchange().expectStatus().isOk.expectBody()
                .jsonPath("\$.message").isEqualTo("hello3")
    }

}