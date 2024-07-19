package com.course.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Arrays;

//@JsonFilter("UserFilter")
@Entity(name = "user_Details")
@Table
public class User {
     @Id
     @GeneratedValue
    private int id;
    @Size(min=3,message="name should contain 3 words")
    //customizing the response by rest api using the jackson properties by @jsonpropety(only field name) annotation.

    @JsonProperty("userName")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "Taxes")
    @JsonProperty("taxes")
    private TaxesRequestStruct[] taxes;

   // @Past(message="Birth date should be in past ")
    //@JsonProperty("birthday")
    //@JsonFilter("birthday")
    private LocalDate birthday;


    public User() {
    }

    public User(int id, String akshay_g, TaxesRequestStruct taxesRequestStruct, LocalDate birthday) {
    }

    public User(int id, String userName, TaxesRequestStruct[] taxes, LocalDate birthday) {
        this.id = id;
        this.userName = userName;
        this.taxes = taxes;
        this.birthday = birthday;
    }

    public void setTaxes(TaxesRequestStruct[] taxes) {
        this.taxes = taxes;
    }

    public TaxesRequestStruct[] getTaxes() {
        return taxes;
    }

    public int getUserId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", taxes=" + Arrays.toString(taxes) +
                ", birthday=" + birthday +
                '}';
    }
}
