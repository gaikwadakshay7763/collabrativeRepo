package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "taxes_request_struct")
public class TaxesRequestStruct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String amount;
    private String rate;


    public TaxesRequestStruct() {
    }

    public TaxesRequestStruct(int id, String amount, String rate) {
        this.id = id;
        this.amount = amount;
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaxesRequestStruct{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}