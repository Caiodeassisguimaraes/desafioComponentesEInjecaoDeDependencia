package com.componenteseinecaodedependencia.desafio.services;


import com.componenteseinecaodedependencia.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private Order order;

    public double shipment (Order order){
        double shipment = 0.0;
        if (order.getBasic() < 100.0) {
            shipment = 20.0;
        } else if (order.getBasic() < 200.0) {
            shipment = 12.0;
        } else {
            shipment = 0.0;
        }
        return shipment;
    }
}
