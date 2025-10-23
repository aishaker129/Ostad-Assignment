package com.finance.controller;

import com.finance.entity.Transaction;
import com.finance.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.createTreansaction(transaction);
        if (newTransaction != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping()
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactionList = transactionService.getAllTransactions();
        if (transactionList != null) {
            return ResponseEntity.ok(transactionList);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.update(id, transaction)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return transactionService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/getByType")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@RequestParam String type) {
        List<Transaction> transactions =transactionService.getByType(type);
        if (transactions != null) {
            return ResponseEntity.ok(transactions);
        }
        return ResponseEntity.notFound().build();
    }

}
