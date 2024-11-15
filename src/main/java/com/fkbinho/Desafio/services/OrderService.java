package com.fkbinho.Desafio.services;

import com.fkbinho.Desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        // Aplica o desconto
        double discountValue = order.getBasic() * (1 - order.getDiscount() / 100);

        // Calcula o frete
        double shippingCost = shippingService.shipment(order.getBasic());

        return discountValue + shippingCost;
    }
}
