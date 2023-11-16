package com.example.testing

import org.springframework.beans.factory.annotation.Value

/**
 * テスト接続先は一回ラップしてローカルとステージングを切り替えられるようにしておくと便利
 */
class WebTestConn(private val port: Int) {
    @Value("\${test.uri}")
    val baseUri = "default string"
    fun uri():String = "$baseUri:$port"
}