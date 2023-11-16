package com.example.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {
@GetMapping("/dummy")
public String dummy() {
    return "Hi! dummy!";
}
}
