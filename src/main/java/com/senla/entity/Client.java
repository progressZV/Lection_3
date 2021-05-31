package com.senla.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min=2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name = null;

    @Min(value = 1, message = "Please enter the correct number of the client room.")
    @NotNull(message = "Please enter the number of the client room.")
    private Integer appsNumber;


    public Client(){ }

    public Integer getAppsNumber() {
        return appsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + "\t" + "\n";
    }
}
