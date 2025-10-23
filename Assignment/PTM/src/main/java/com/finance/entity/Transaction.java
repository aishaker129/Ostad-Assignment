package com.finance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private  Long id;
    private  String title;
    private double amount;
    private String type; // "income" or "expense"



}
