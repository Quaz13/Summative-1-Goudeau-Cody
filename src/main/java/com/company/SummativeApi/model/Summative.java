package com.company.SummativeApi.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Summative {

    @NotEmpty(message = "You must supply a value for author")
    private String author;
    @NotEmpty(message = "You must supply a value for quote")
    private String quote;
    private int id;

    //default constructor
    public Summative(){}

    //Constructor
    public Summative(String author, String quote, int id){

        this.author = author;
        this.quote = quote;
        this.id = id;

    }

    //getters and setters


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.company.SummativeApi.model.Summative summative = (com.company.SummativeApi.model.Summative) o;
        return Objects.equals(getAuthor(), summative.getAuthor()) && Objects.equals(getQuote(), summative.getQuote()) && Objects.equals(getId(), summative.getId());
    }

    @Override
    public int hashCode() {return Objects.hash(getAuthor(), getQuote(), getId()); }
}
