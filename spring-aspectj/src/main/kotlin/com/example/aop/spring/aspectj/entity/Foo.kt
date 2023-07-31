package com.example.aop.spring.aspectj.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class Foo(@Id private val id: Long)