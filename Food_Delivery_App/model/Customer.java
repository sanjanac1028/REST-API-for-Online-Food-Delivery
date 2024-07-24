package com.foodapp.Food_Delivery_App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer customerId;
    private String fullName;
    private Integer age;
    private String gender;
    private String mobileNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private FoodCart foodCart;
}
