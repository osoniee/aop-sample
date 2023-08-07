package com.example.aop.spring.aspectj.controller

import com.example.aop.spring.aspectj.service.FooService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController(
    private val fooService: FooService
)
{
    @GetMapping
    fun foo() {
        fooService.invokeSelfRegistration()
    }
}