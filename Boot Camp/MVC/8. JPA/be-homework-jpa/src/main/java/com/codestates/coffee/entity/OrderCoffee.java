package com.codestates.coffee.entity;

import com.codestates.order.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
    private long orderCoffeeId;

    @ManyToOne
    @JoinColumn(name = "COFFEE_ID", nullable = false)
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @Column(nullable = false)
    private int quantity;

    //coffee에는 단방향 매핑
    public void addCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public void addOrder(Order order) {
        this.order = order;
    }

    public OrderCoffee(int quantity) {
        this.quantity = quantity;
    }
}