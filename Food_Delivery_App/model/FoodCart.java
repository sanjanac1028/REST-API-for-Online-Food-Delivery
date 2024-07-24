package com.foodapp.Food_Delivery_App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodCart {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer cartId;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Customer customer;
    @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
    private List<Item> itemList;
}
