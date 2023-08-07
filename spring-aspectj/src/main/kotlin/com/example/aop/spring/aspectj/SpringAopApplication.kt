package com.example.aop.spring.aspectj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringAopApplication

fun main(args: Array<String>) {
    runApplication<SpringAopApplication>(*args)
}
