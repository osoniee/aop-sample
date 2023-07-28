package com.example.aop.spring.cglib.store

import com.example.aop.spring.cglib.entity.Foo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FooStore: JpaRepository<Foo, Long>