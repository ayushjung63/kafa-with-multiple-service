package com.ayush.productservice.pojos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPOJO {
    private Long userId;
    private Long productId;

    private String orderBy;
    private String productName;
    private Double price;
}
