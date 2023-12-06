package com.example.testing

import com.example.testing.logic.Calc
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingKotlinController {
    @GetMapping("/hello")
    fun hello(model: org.springframework.ui.Model): HelloResponse {
        val x = Calc().add(1,2)
        return HelloResponse("hello$x")
    }
}