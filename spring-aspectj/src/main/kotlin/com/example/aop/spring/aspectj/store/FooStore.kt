package com.example.aop.spring.aspectj.store

import com.example.aop.spring.aspectj.entity.Foo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FooStore: JpaRepository<Foo, Long>