package com.musala.orders.services;

import java.util.List;

import com.musala.orders.model.TomatoOrder;

public interface TomatoOrdersService {
	
	
	/**
	 * @param size
	 * @return
	 */
	List<TomatoOrder> getTomatoOrders(int size);
}
