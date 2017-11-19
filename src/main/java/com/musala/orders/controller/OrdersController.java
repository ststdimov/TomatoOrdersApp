package com.musala.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.orders.model.TomatoOrder;
import com.musala.orders.services.TomatoOrdersService;


/**
 * The OrdersController class is used to handle
 * incoming REST GET requests for tomato orders.
 * The only allowed origin for requests is 
 * http://localhost:4200 , because the client 
 * is available at this URL. If you use another URL
 * for client application, please change the value
 * of origins attribute of the CrossOrigin annotation below.
 * 
 * @author stanimir.dimov
 *
 */

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins="http://localhost:4200")
public class OrdersController {
	
	@Autowired
	TomatoOrdersService tomatoOrdersService;
	
	/**
	 * This method is used to handle GET requests
	 * about tomato orders
	 * @param size This parameter specifies the amount of
	 * the requested orders. If the parameter is omitted in the request
	 * the default value is 3
	 * @return List<TomatoOrder> 
	 * 
	 */
	@GetMapping("/data")
	public List<TomatoOrder> getOrders(@RequestParam(defaultValue = "3") int size) {
		return tomatoOrdersService.getTomatoOrders(size);
	}
}
