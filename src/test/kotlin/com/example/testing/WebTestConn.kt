package com.example.testing

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * テスト接続先は一回ラップしてローカルとステージングを切り替えられるようにしておくと便利
 */
@Component
class WebTestConn {
    var port=80
    @Value("\${test.uri}")
    val baseUri = "default string"
    fun uri():String = "$baseUri:$port"
    fun setup(port:Int) {
        this.port = port
    }
}