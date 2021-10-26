package com.company.SummativeApi.model;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;




public class Words {

    @NotEmpty(message = "You must supply a value for word.")
    private String word;
    @NotEmpty(message = "You must supply a value for definition.")
    private String definition;
    private int id;

    //default constructor
    public Words(){}

    //Constructor
    public Words(String word, String definition, int id) {

        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    //getters and setters


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //equality

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.company.SummativeApi.model.Words words = (com.company.SummativeApi.model.Words) o;
        return Objects.equals(getWord(), words.getWord()) && Objects.equals(getDefinition(), words.getDefinition()) && Objects.equals(getId(), words.getId());
    }

    @Override
    public int hashCode() { return Objects.hash(getWord(), getDefinition(), getId());}
}
