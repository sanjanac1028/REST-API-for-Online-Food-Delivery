package com.foodapp.Food_Delivery_App.authmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LogInModel {

    @NotNull
    @Id
    private Integer userId;
    private String userName;
    private String password;
}
