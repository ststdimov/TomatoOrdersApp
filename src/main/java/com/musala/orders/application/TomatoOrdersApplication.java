package com.musala.orders.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Tomato orders web application is implements logic
 * to generate random tomato orders for different providers.
 * A tomato order includes properties like id, provider,
 * quantity of tomatoes measured in kilograms and 
 * date of the order. More information about constraints on
 * the properties of the orders could be found at 
 * {@see com.musala.orders.repository.TomatoOrdersDaoImpl}
 *
 * The application handles REST requests and return desired
 * amount of tomato orders.
 * 
 * The TomatoOrdersApplication class is used as starting point
 * of Spring MVC web application.
 * 
 * @author stanimir.dimov
 * @version 1.0
 * @since 19.11.2017
 */
@SpringBootApplication(scanBasePackageClasses={
			com.musala.orders.controller.OrdersController.class,
			com.musala.orders.services.TomatoOrdersService.class,
			com.musala.orders.repository.TomatoOrdersDao.class})
public class TomatoOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomatoOrdersApplication.class, args);
	}
}
