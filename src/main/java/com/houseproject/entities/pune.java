package com.houseproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pune_house_data")
public class pune {
    // ...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //change here
    private String area_type;
    private String availability;
    private String size;
    private String society;
    private int total_sqft;
    private int bath;
    private int balcony;
    private int price;
    @Column
    private String site_location;
    // ...
    // Getters and setters
}
