package com.yt.market.dto;

import com.yt.market.entities.OrderItem;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {

    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(OrderItem oi) {
        this.productId = oi.getProduct().getId();
        this.productTitle = oi.getProduct().getTitle();
        this.quantity = oi.getQuantity();
        this.pricePerProduct = oi.getPricePerProduct();
        this.price = oi.getPrice();
    }
}
