package com.example.aop.spring.cglib.service

import com.example.aop.spring.cglib.entity.Foo
import com.example.aop.spring.cglib.store.FooStore
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Service
class FooTransactionService(private val fooStore: FooStore) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Transactional
    fun startTransaction() = log.debug("current transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())

    fun invokeSelfTransaction() = startTransaction()

    @Transactional
    fun registerWithTransaction() {
        log.debug("fun register transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())
        fooStore.save(Foo("foo"))
        throw RuntimeException("ERROR")
    }

    fun invokeSelfRegistration() {
        log.debug("fun invokeSelfRegistration transaction: {}", TransactionSynchronizationManager.getCurrentTransactionName())
        fooStore.save(Foo("bar"))
        registerWithTransaction()
    }
}