package com.example.simplemoneycalculator;

public class List {
    private int id;
    private String title;
    private double value;
    int entryType;

    public List(){}

    public List(int id, String title, double value, int entryType){
        this.id = id;
        this.title = title;
        this.value = value;
        this.entryType = entryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getEntryType() {
        return entryType;
    }

    public void setEntryType(int entryType) {
        this.entryType = entryType;
    }
}
