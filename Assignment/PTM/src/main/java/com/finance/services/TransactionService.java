package com.finance.services;

import com.finance.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final List<Transaction> listTransaction = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public  Transaction createTreansaction(Transaction transaction){
        Transaction treansaction = new Transaction();
        treansaction.setId(idCounter.incrementAndGet());
        treansaction.setTitle(transaction.getTitle());
        treansaction.setAmount(transaction.getAmount());
        treansaction.setType(transaction.getType());
        listTransaction.add(treansaction);
        return treansaction;
    }

    public List<Transaction> getAllTransactions(){
        return listTransaction;
    }

    public Optional<Transaction> getTransactionById(Long id){
        return listTransaction
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Optional<Transaction> update(Long id, Transaction newT) {
        return getTransactionById(id).map(t -> {
            t.setTitle(newT.getTitle());
            t.setAmount(newT.getAmount());
            t.setType(newT.getType());
            return t;
        });
    }

    public boolean delete(Long id) {
        return listTransaction.removeIf(t -> t.getId().equals(id));
    }

    public List<Transaction> getByType(String type) {
        return listTransaction.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

}
