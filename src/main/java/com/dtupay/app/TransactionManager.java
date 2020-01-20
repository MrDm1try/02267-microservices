package com.dtupay.app;

import com.dtupay.database.ITransactionAdapter;
import com.dtupay.database.exceptions.CustomerDoesNotExist;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class TransactionManager implements ITransactionManager {

    private ITransactionAdapter transactionAdapter;

    public TransactionManager(ITransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @Override
    public List<TransactionCustomer> getCustomerMonthlyReport(int customerId, int month, int year) throws CustomerDoesNotExist {
        return transactionAdapter.getMonthlyTransactionsByCustomerId(customerId, month, year);
}

    @Override
    public List<TransactionMerchant> getMerchantMonthlyReport(int merchantId, int month, int year) {

        return transactionAdapter.getMonthlyTransactionsByMerchantId(merchantId, month, year);
    }

    @Override
    public Transaction registerTransaction(Timestamp timestamp, int fromId, int toId, int tokenId, BigDecimal amount, boolean isRefund) {
        return transactionAdapter.addTransaction(timestamp, fromId, toId, tokenId, amount, isRefund);
    }
}
