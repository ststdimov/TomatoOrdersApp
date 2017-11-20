package com.musala.orders.application;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.orders.controller.OrdersController;
import com.musala.orders.model.TomatoOrder;
import com.musala.orders.repository.TomatoOrdersDao;
import com.musala.orders.services.TomatoOrdersService;


@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
public class WebMVCTest {

	private static final int DEFAULT_ORDERS_SIZE = 3;
	private static final int ORDERS_SIZE = 2;

	private List<TomatoOrder> orders;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TomatoOrdersService ordersService;

	@MockBean
	private TomatoOrdersDao ordersDao;

	@MockBean
	private TomatoOrder mockedOrder;

	@Before
	public void setup() throws Exception {
		this.orders = new LinkedList<TomatoOrder>();
		mockedOrder = new TomatoOrder();
		mockedOrder.setId("1");
		mockedOrder.setProvider("Heinz");
		
	}

	@Test
	public void shouldRetrieveOrdersWithoutSize() throws Exception {

		initOrders(DEFAULT_ORDERS_SIZE);

		ObjectMapper mapper = new ObjectMapper();
		when(ordersService.getTomatoOrders(DEFAULT_ORDERS_SIZE)).thenReturn(this.orders);
		mockMvc.perform(get("/orders/data"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(mapper.writeValueAsString(this.orders)));
	}

	@Test
	public void shouldRetrieveOrdersWithSizeParam() throws Exception {

		initOrders(ORDERS_SIZE);
		ObjectMapper mapper = new ObjectMapper();

		when(ordersService.getTomatoOrders(ORDERS_SIZE)).thenReturn(this.orders);
		mockMvc.perform(get("/orders/data")
				.param("size", String.valueOf(ORDERS_SIZE)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(mapper.writeValueAsString(this.orders)));
	}

	
	
	
	private void initOrders(int size) {
		for (int i = 0; i < size; i++) {
			this.orders.add(this.mockedOrder);
		}
	}
}
