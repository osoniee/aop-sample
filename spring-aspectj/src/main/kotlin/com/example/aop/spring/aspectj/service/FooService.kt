package com.example.aop.spring.aspectj.service

import com.example.aop.spring.aspectj.aspect.Logged
import com.example.aop.spring.aspectj.entity.Foo
import com.example.aop.spring.aspectj.store.FooStore
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Service
@EnableAspectJAutoProxy
class FooService(private val fooStore: FooStore) {
    private val log = LoggerFactory.getLogger(this::class.java)
    @Autowired private lateinit var fooService: FooService;
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
        registerWithTransaction()
    }
}