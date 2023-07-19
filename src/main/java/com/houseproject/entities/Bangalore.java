package com.houseproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bangalore_house_data")
public class Bangalore  {
    // ...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //change here

    private String area_type;
    private String availability;
    private String size;
    private String society;
    private String total_sqft;
    private String bath;
    private String balcony;
    private String price;
@Column
    private String location;
    // ...
    // Getters and setters
}

