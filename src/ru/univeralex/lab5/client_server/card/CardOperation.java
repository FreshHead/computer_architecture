package ru.univeralex.lab5.client_server.card;

import java.util.*;
import java.io.*;


public class CardOperation implements Serializable {
    public CardOperation(String card,double amount,Date operationDate){
        this.card = card;
        this.amount = amount;
        this.operationDate = operationDate;
    }
    public String card;
    public double amount;
    public Date operationDate;
}