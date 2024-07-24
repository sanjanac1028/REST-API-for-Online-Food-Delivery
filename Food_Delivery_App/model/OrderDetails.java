package com.foodapp.Food_Delivery_App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderId;
    private LocalDate orderDate;
    private String orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private FoodCart foodCart;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Bill bill;
}
