package com.musala.orders.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses={
			com.musala.orders.controller.OrdersController.class,
			com.musala.orders.services.TomatoOrdersService.class,
			com.musala.orders.repository.TomatoOrdersDao.class})
public class TomatoOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomatoOrdersApplication.class, args);
	}
}
