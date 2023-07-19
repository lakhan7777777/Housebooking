package com.houseproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Delhi_house_data")
public class Delhi {
    // ...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //change here
    private int Area;
    private int BHK;
    private int Bathroom;
    private String Furnishing;
    @Column
    private String locality;
    private int Parking;
    private String Price;
    private String Transaction;
    private String Type;
    private int Per_Sqft;
    // ...
    // Getters and setters
}

