package com.example.webclienttesting.application

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class GreetingController {
    @GetMapping("/hello")
    fun hello():HelloResponse {
        return HelloResponse("hello")
    }
}