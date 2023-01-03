package com.componenteseinecaodedependencia.desafio;

import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import services.OrderService;
import services.ShippingService;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.componenteseinecaodedependencia"})
public class DesafioApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShippingService shippingService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Dados do pedido: ");
		System.out.print("Código: ");
		Integer code = sc.nextInt();
		System.out.print("Valor Básico: ");
		Double basicValue = sc.nextDouble();
		System.out.print("Porcentagem de Desconto: ");
		Double discountPercent = sc.nextDouble();

		Order order = new Order(code, basicValue, discountPercent);
		System.out.println("Pedido código " + order.getCode());
		//System.out.println("Valor do frete: R$" + shippingService.shipment(order));
		System.out.println("Valor total: R$" + orderService.total(order));

		sc.close();
	}
}
