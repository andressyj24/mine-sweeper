package com.exercise.minesweeper.adapters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @GetMapping("/")
    public String greeting() {
        return "Welcome to Minesweeper Game!";
    }
}
