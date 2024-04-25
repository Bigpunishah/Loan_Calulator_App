package com.example.simplemoneycalculator;

public class Loans {
    private int loanId;
    private int listId;
    private String title;
    private String description;
    private double loanAmount;
    private double loanTermInYears;
    private double interestRate;
    private String payRate;
    private double payments;
    private double totalPayback;
    private double totalInterest;

    public Loans(){
        title = "";
        description = "";
        loanAmount = 0;
        loanTermInYears = 0;
        interestRate = 0;
        payRate = "";
        payments = 0;
        totalPayback = 0;
        totalInterest = 0;
    }

    public Loans(int listId, String title, String description, double loanAmount, double loanTermInYears, double interestRate, String payRate, double payments, double totalPayback, double totalInterest){
        this.listId = listId;
        this.title = title;
        this.description = description;
        this.loanAmount = loanAmount;
        this.loanTermInYears = loanTermInYears;
        this.interestRate = interestRate;
        this.payRate = payRate;
        this.payments = payments;
        this.totalPayback = totalPayback;
        this.totalInterest = totalInterest;
    }

    public Loans(int listId, int loanId, String title, String description, double loanAmount, double loanTermInYears, double interestRate, String payRate, double payments, double totalPayback, double totalInterest){
        this.listId = listId;
        this.loanId = loanId;
        this.title = title;
        this.description = description;
        this.loanAmount = loanAmount;
        this.loanTermInYears = loanTermInYears;
        this.interestRate = interestRate;
        this.payRate = payRate;
        this.payments = payments;
        this.totalPayback = totalPayback;
        this.totalInterest = totalInterest;
    }

    //Getter & Setter
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanTermInYears() {
        return loanTermInYears;
    }

    public void setLoanTermInYears(double loanTermInYears) {
        this.loanTermInYears = loanTermInYears;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public double getTotalPayback() {
        return totalPayback;
    }

    public void setTotalPayback(double totalPayback) {
        this.totalPayback = totalPayback;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }
}
