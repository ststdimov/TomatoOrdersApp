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


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins="*")
public class OrdersController {
	
	@Autowired
	TomatoOrdersService tomatoOrdersService;
	
	@GetMapping("/data")
	public List<TomatoOrder> getOrders(@RequestParam(defaultValue = "3") int size) {
		return tomatoOrdersService.getTomatoOrders(size);
	}
}
