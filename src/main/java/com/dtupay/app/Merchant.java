package com.dtupay.app;

import java.util.ArrayList;
import java.util.List;

public class Merchant {
    String name;
    int id;
    List<Token> tokens;
    IDtuPayApp dtuPay;

    public Merchant () {}

    public Merchant(int _id, String _name) {
        id = _id;
        name = _name;
        tokens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IDtuPayApp getDtuPay() {
        return dtuPay;
    }

    public void setDtuPay(IDtuPayApp dtuPay) {
        this.dtuPay = dtuPay;
    }

    public boolean scanCustomerToken(Token customerToken){
        // should return true if token is not used
        return !customerToken.used;
    }
}
