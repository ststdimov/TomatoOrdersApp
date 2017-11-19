package com.musala.orders.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsIn.isIn;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.musala.orders.model.TomatoOrder;
import com.musala.orders.repository.TomatoOrdersDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersDaoTest {
	
	private static final int TEST_ORDERS_SIZE = 10;
	private static final String[] TEST_PROVIDERS = { "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma" }; 
	
	@Autowired
	private TomatoOrdersDao tomatoOrdersDao;
	
	@Test
	public void shouldReturnCorrectSize() {
		List<TomatoOrder> ordersList = this.tomatoOrdersDao.getOrders(TEST_ORDERS_SIZE);
		
		assertThat(ordersList.size()).isEqualTo(TEST_ORDERS_SIZE);
	}
	
	@Test
	public void shouldNotBeNull() {
		List<TomatoOrder> ordersList = this.tomatoOrdersDao.getOrders(TEST_ORDERS_SIZE);
		
		assertThat(ordersList).isNotNull();
	}
	
	@Test
	public void providerShouldBeInProvidersList() {
		List<TomatoOrder> ordersList = this.tomatoOrdersDao.getOrders(TEST_ORDERS_SIZE);
		
		assertThat(ordersList,everyItem(hasProperty("provider",isIn(TEST_PROVIDERS))));
		
	}
	
	@Test
	public void timestampShouldBeInInterval() {
		Calendar calendarInst = Calendar.getInstance();
		
		final long endOfPeriod = calendarInst.getTimeInMillis();
		calendarInst.set(Calendar.DAY_OF_YEAR,1);
		final long startOfPeriod = calendarInst.getTimeInMillis();
		
		List<TomatoOrder> ordersList = this.tomatoOrdersDao.getOrders(TEST_ORDERS_SIZE);
		assertThat(ordersList,everyItem(hasProperty("timestamp",
				both(greaterThan(startOfPeriod))
				.and(lessThan(endOfPeriod)))));
		
	}
	
	@Test
	public void testTomatoesQuantityForInterval() {
		
		final int minQuantity = 0;
		final int maxQuantity = 2000;
		
		List<TomatoOrder> ordersList = this.tomatoOrdersDao.getOrders(TEST_ORDERS_SIZE);
		assertThat(ordersList,everyItem(hasProperty("tomatoes",
				both(greaterThan(minQuantity))
				.and(lessThan(maxQuantity)))));
		
	}
	
}
