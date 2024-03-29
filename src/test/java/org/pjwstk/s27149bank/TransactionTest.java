package org.pjwstk.s27149bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {
    @Test
    void getStatus() {
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, 0);
        TransactionStatus status = transaction.getStatus();
        assertThat(status != null).isTrue();
    }
    @Test
    void getStatusAccepted() {
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, 0);
        TransactionStatus status = transaction.getStatus();
        assertThat(status == TransactionStatus.ACCEPTED).isTrue();
    }

    @Test
    void getStatusDeclined() {
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, 0);
        TransactionStatus status = transaction.getStatus();
        assertThat(status == TransactionStatus.DECLINED).isTrue();
    }

    @Test
    void getBalance() {
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, 0);
        double balance = transaction.getBalance();
        assertThat(balance == 0).isTrue();
    }
}