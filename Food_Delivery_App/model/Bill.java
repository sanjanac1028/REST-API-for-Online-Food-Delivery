package com.foodapp.Food_Delivery_App.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billId;
    private LocalDate billDate;
    private Double totalCost;
    private Integer totalItem;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderDetails orderDetails;
}
