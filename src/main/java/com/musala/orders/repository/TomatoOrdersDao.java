package com.musala.orders.repository;

import java.util.List;


import com.musala.orders.model.TomatoOrder;

/**
 * @author stanimir.dimov
 * This interface is used instead of Spring Repository,
 * because of the lack of persistence layer.
 * This DAO interface defines logic for generating and providing
 * list of random tomato orders. 
 *
 */


public interface TomatoOrdersDao {
	
	/**
	 * @param size This parameter defines size of the generated
	 * orders
	 * @return List of randomly generated orders. Each order has 
	 * constraints about its properties.
	 * For more information look at comments on the getter and 
	 * setter methods of the following class
	 * {@see com.musala.orders.repository.TomatoOrder}
	 */
	public List<TomatoOrder> getOrders(int size);
}
