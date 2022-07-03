package com.ayush.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence",allocationSize = 1,sequenceName = "product_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_sequence")
    private Long id;

    private String name;

    private Double price;
}
