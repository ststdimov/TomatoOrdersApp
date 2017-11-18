package com.musala.orders.application;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.musala.orders.controller.OrdersController;
import com.musala.orders.repository.TomatoOrdersDao;
import com.musala.orders.repository.TomatoOrdersDaoImpl;
import com.musala.orders.services.TomatoOrdersService;
import com.musala.orders.services.TomatoOrdersServiceImpl;




@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
public class FullIntegrationTest {

	private static final int DEFAULT_ORDERS_SIZE = 3;
	private static final int ORDERS_SIZE = 10;

	@Autowired
	private MockMvc mockMvc;

	
	@Autowired 
	TomatoOrdersService ordersService;
	
	@Autowired
	TomatoOrdersDao ordersDao;
	
	@TestConfiguration
	static class DependenciesConfiguration {
		
		@Bean
		TomatoOrdersService ordersService() {
			return new TomatoOrdersServiceImpl();
		}
		
		@Bean
		TomatoOrdersDao ordersDao() {
			return new TomatoOrdersDaoImpl();
		}
	}


	@Test
	public void fullTestWithoutSizeParam() throws Exception {
		
		mockMvc.perform(get("/orders/data"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()", is(DEFAULT_ORDERS_SIZE)));
	}
	
	@Test
	public void fullTestWithSizeParam() throws Exception {
		
		mockMvc.perform(get("/orders/data")
				.param("size", String.valueOf(ORDERS_SIZE)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(ORDERS_SIZE)));
	}
	
}

