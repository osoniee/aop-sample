package com.example.aop.spring.aspectj.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Foo(@Id private val id: Long)