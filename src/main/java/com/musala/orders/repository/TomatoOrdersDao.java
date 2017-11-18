package com.musala.orders.repository;

import java.util.List;


import com.musala.orders.model.TomatoOrder;

/**
 * @author stanimir.dimov
 * This interface is used instead of Spring Repository,
 * because of the absence of persistence layer.
 *
 */


public interface TomatoOrdersDao {
	
	/**
	 * @param size
	 * @return
	 */
	public List<TomatoOrder> getOrders(int size);
}
