package com.musala.orders.repository;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.musala.orders.model.TomatoOrder;
import com.musala.orders.services.TomatoOrdersServiceImpl;

@Component
public class TomatoOrdersDaoImpl implements TomatoOrdersDao {
	
	private static final Logger log = LoggerFactory.getLogger(TomatoOrdersDaoImpl.class);
	private static final int MAX_TOMATOES_PER_ORDER = 2000;
	private static final  String[] PROVIDERS = { "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma" };
	private static Random randomGenerator = new Random();
		
	@Override
	public List<TomatoOrder> getOrders(int size) {
		
		List<TomatoOrder> tomatoOrders = new LinkedList<TomatoOrder>();
		
		for(int i = 0; i < size; i++) {
			tomatoOrders.add(generateTomatoOrder());
		}
		
		log.info("Number of generated tomato orders is " + tomatoOrders.size());
		return tomatoOrders;
	}

	
	
	/**
	 * @return Return randomly generated order with the following constraints:
	 * id should be valid UUID
	 * provider should be one from the list : "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"
	 * timestamp should be in interval defined by the start of the year and 
	 * the current time
	 * tomatoes should be between 0 and 2000
	 */
	private TomatoOrder generateTomatoOrder() {
		TomatoOrder tomatoOrder = new TomatoOrder();
		
		tomatoOrder.setId(UUID.randomUUID().toString());
		
		int providerIndex = randomGenerator.nextInt(PROVIDERS.length);
		tomatoOrder.setProvider(PROVIDERS[providerIndex]);
		tomatoOrder.setTomatoes(randomGenerator.nextInt(MAX_TOMATOES_PER_ORDER));
		tomatoOrder.setTimestamp(generateTimestamp());
		return tomatoOrder;
	}
	
	private long generateTimestamp() {
		Calendar calendar = Calendar.getInstance();
		
		long endOfPeriod = calendar.getTimeInMillis();
		calendar.set(Calendar.DAY_OF_YEAR,1);
		long startOfPeriod = calendar.getTimeInMillis();
		
		return randomGenerator.longs(1,startOfPeriod, endOfPeriod).findFirst().getAsLong();
	}
	

}
