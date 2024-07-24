package com.foodapp.Food_Delivery_App.authmodels;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private Integer userId;
    private String UUID;
    private LocalDateTime timeStamp;
    public UserSession(Integer userId,String UUID,LocalDateTime timeStamp)
    {
        super();
        this.userId = userId;
        this.UUID = UUID;
        this.timeStamp = timeStamp;
    }

}
