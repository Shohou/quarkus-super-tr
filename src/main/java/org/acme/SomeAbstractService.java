package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;

import java.util.concurrent.ThreadLocalRandom;

public abstract class SomeAbstractService {

    @Inject
    TransactionManager transactionManager;

    @Transactional
    public String doSomething() {
        System.out.println("SomeAbstractService.doSomething()");
        try {
            System.out.println("Transaction status - " + transactionManager.getStatus());
        } catch (SystemException e) {
            e.printStackTrace();
        }
        MyEntity myEntity = MyEntity.findById(1);
        doPersist(myEntity);
        return myEntity.getField();
    }

    @Transactional
    void doPersist(MyEntity myEntity) {
        myEntity.setField("field-" + ThreadLocalRandom.current().nextInt(10));
        myEntity.persist();
    }
}
