package com.example.aop.spring.cglib.entity

import com.example.aop.spring.cglib.annotation.Logged
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Foo(@Id private val id: String) {
    @Logged
    fun bar() = println("==========bar==========")
}