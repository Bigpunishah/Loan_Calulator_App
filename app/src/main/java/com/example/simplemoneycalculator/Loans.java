package com.example.simplemoneycalculator;

public class Loans {
    private int loanId;
    private int listId;
    private String title;
    private String description;
    private double loanAmount;
    private double loanTermInYears;
    private double interestRate;
    private double payRate;

    public Loans(){
        title = "";
        description = "";
        loanAmount = 0;
        loanTermInYears = 0;
        interestRate = 0;
        payRate = 0;
    }

    public Loans(int listId, String title, String description, double loanAmount, double loanTermInYears, double interestRate, double payRate){
        this.listId = listId;
        this.title = title;
        this.description = description;
        this.loanAmount = loanAmount;
        this.loanTermInYears = loanTermInYears;
        this.interestRate = interestRate;
        this.payRate = payRate;
    }

    public Loans(int listId, int loanId, String title, String description, double loanAmount, double loanTermInYears, double interestRate, double payRate){
        this.listId = listId;
        this.loanId = loanId;
        this.title = title;
        this.description = description;
        this.loanAmount = loanAmount;
        this.loanTermInYears = loanTermInYears;
        this.interestRate = interestRate;
        this.payRate = payRate;
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

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}
