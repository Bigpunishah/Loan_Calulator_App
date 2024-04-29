package com.example.simplemoneycalculator;

public class Savings {
    private int savingsId;
    private int listId;
    private String title;
    private String description;
    private double initialAmount;
    private String depositFrequency;
    private double depositAmount;
    private double duration;
    private double interest;
    private double totalContributions;
    private double totalInterest;
    private double totalAmount;


    public Savings(int listId, String title, String description, double initialAmount, String depositFrequency, double depositAmount, double duration, double interest, double totalContributions, double totalInterest, double totalAmount){
        this.listId = listId;
        this.title = title;
        this.description = description;
        this.initialAmount = initialAmount;
        this.depositFrequency = depositFrequency;
        this.depositAmount = depositAmount;
        this.duration = duration;
        this.interest = interest;
        this.totalContributions = totalContributions;
        this.totalInterest = totalInterest;
        this.totalAmount = totalAmount;
    }

    public Savings(int listId, int savingsId, String title, String description, double initialAmount, String depositFrequency, double depositAmount, double duration, double interest, double totalContributions, double totalInterest, double totalAmount){
        this.listId = listId;
        this.savingsId = savingsId;
        this.title = title;
        this.description = description;
        this.initialAmount = initialAmount;
        this.depositFrequency = depositFrequency;
        this.depositAmount = depositAmount;
        this.duration = duration;
        this.interest = interest;
        this.totalContributions = totalContributions;
        this.totalInterest = totalInterest;
        this.totalAmount = totalAmount;
    }

    public int getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(int savingsId) {
        this.savingsId = savingsId;
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

    public double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getDepositFrequency() {
        return depositFrequency;
    }

    public void setDepositFrequency(String depositFrequency) {
        this.depositFrequency = depositFrequency;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getTotalContributions() {
        return totalContributions;
    }

    public void setTotalContributions(double totalContributions) {
        this.totalContributions = totalContributions;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
