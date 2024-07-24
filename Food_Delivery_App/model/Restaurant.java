package com.foodapp.Food_Delivery_App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;
    private String restaurantName;
    private String managerName;
    private String contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

}
