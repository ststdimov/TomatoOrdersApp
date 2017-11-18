package com.musala.orders.repository;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.musala.orders.model.TomatoOrder;

@Component
public class TomatoOrdersDaoImpl implements TomatoOrdersDao {

	private final static int MAX_TOMATOES_PER_ORDER = 2000;
	private final static String[] PROVIDERS = { "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma" };
	private static Random randomGenerator = new Random();
		
	
	@Override
	public List<TomatoOrder> getOrders(int size) {
		
		List<TomatoOrder> tomatoOrders = new LinkedList<TomatoOrder>();
		
		for(int i = 0; i < size; i++) {
			tomatoOrders.add(generateTomatoOrder());
		}
		
		return tomatoOrders;
	}

	
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
