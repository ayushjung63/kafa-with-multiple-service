package com.ayush.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence",allocationSize = 1,sequenceName = "order_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_sequence")
    private Long id;

    private Long userId;
    private Long productId;

    private String orderBy;
    private String productName;
    private Double price;
}
