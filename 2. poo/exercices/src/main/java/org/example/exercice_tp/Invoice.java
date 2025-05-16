package org.example.exercice_tp;

import java.time.LocalDate;

public class Invoice {

    int lines = 10;
    long invoiceNum;
    Customer customer;
    LocalDate date;

    Line[] quantity = new Line[lines];

    public Invoice(int lines, long invoiceNum, Customer customer, LocalDate date, Line[] quantity) {
        this.lines = lines;
        this.invoiceNum = invoiceNum;
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
    }

    public Invoice(long invoiceNum, Customer customer, LocalDate date, Line[] quantity) {
        this.invoiceNum = invoiceNum;
        this.customer = customer;
        this.date = date;
        this.quantity = quantity;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Line[] getQuantity() {
        return quantity;
    }

    public void setQuantity(Line[] quantity) {
        this.quantity = quantity;
    }

    public Line addLine(String ref, int quantity){
        return new Line(ref, quantity);
    }

    public double getTotal(){
        double sum = 0;
        for(Line line : quantity) {
            sum += line.getTotal();
        }
        return sum;
    }
}
