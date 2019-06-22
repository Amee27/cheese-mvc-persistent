package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */

@Entity // Tells Spring Boot that you want to store this information in a database. Every property in this class will be stored in a database unless you tell it not to.
public class Cheese {

    @Id // Ask the data layer this will be our PRIMARY KEY.
    @GeneratedValue // Hibernate will generate that value for us to assure it's unique.
    private int id;

    @NotNull
    @Size(min=3, max=25)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne // Hibernate will translate this into storing the primary key from the specified class table as a foreign key on this one.
    private Category category;

    @ManyToMany(mappedBy = "cheeses", cascade = CascadeType.ALL) // Should determine the mapping for this collection by looking at the cheeses property on the menu class.
    private List<Menu> menus;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
