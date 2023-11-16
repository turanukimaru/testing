package com.example.testing

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Controller
//@RestController
class GreetingController {
    @GetMapping("/hello")
    fun hello(model: org.springframework.ui.Model):HelloResponse {
        return HelloResponse("hello")
    }
}