package com.example.aop.spring.aspectj.service

import aspectj.Logged
import com.example.aop.spring.aspectj.entity.Foo
import com.example.aop.spring.aspectj.store.FooStore
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Service
class FooService(private val fooStore: FooStore) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Logged
    @Transactional
    fun startTransaction() = log.debug("current transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())

    @Logged
    fun invokeSelfTransaction() = startTransaction()

    @Logged
    @Transactional
    fun registerWithTransaction() {
        log.debug("register transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())
        fooStore.save(Foo(1))
        throw RuntimeException("ERROR")
    }

    @Logged
    fun invokeSelfRegistration() {
        log.debug("invokeSelfRegistration transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())
        fooStore.save(Foo(2))
        registerWithTransaction()
    }
}