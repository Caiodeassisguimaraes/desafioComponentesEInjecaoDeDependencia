package services;

import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private Order order;
    @Autowired
    private ShippingService shippingService;
    public double total (Order order){
        return order.getBasic() + shippingService.shipment(order) - (order.getDiscount() * order.getBasic()/100);
    }
}
