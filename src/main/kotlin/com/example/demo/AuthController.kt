package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthController {

    // Страница логина
    @GetMapping("/login")
    fun login(): String {
        return "login"  // Имя шаблона для страницы логина
    }

    // Страница регистрации
    @GetMapping("/register")
    fun register(): String {
        return "register"  // Имя шаблона для страницы регистрации
    }

    // Обработка POST-запроса для логина
    @PostMapping("/login")
    fun processLogin(@RequestParam username: String, @RequestParam password: String): String {
        println("User login attempt: Username: $username, Password: $password")
        return "redirect:/login"  // Переадресация обратно на страницу логина
    }

    // Обработка POST-запроса для регистрации
    @PostMapping("/register")
    fun processRegister(@RequestParam username: String, @RequestParam password: String, @RequestParam confirmPassword: String): String {
        if (password != confirmPassword) {
            println("Passwords do not match!")
            return "redirect:/register"  // Перенаправление обратно на страницу регистрации
        }
        println("User registered: Username: $username, Password: $password")
        return "redirect:/login"  // После регистрации перенаправляем на страницу логина
    }
}
