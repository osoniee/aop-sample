package com.example.aop.spring.cglib

import com.example.aop.spring.cglib.service.FooTransactionService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FooTest {
    @Autowired private lateinit var fooTransactionService: FooTransactionService

    @Test
    fun startTransactionTest() = fooTransactionService.startTransaction()

    @Test
    fun invokeSelfTransactionTest() = fooTransactionService.invokeSelfTransaction()

    @Test
    fun registerTest() = fooTransactionService.registerWithTransaction()

    @Test
    fun selfInvokeRegisterTest() = fooTransactionService.invokeSelfRegistration()
}