package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 25)
    private String name;

    @OneToMany // Ask Hibernate that you want it to store these cheeses as a one to many relationship
    @JoinColumn(name = "category_id") // This ask what column on the cheese table should determine the cheeses that are a part of this list
    private List<Cheese> cheeses = new ArrayList<>();

    public Category() { }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

}
