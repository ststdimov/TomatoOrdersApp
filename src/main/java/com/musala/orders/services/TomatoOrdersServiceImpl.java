package com.musala.orders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.orders.model.TomatoOrder;
import com.musala.orders.repository.TomatoOrdersDao;

@Service
public class TomatoOrdersServiceImpl implements TomatoOrdersService{

	@Autowired 
	TomatoOrdersDao tomatoOrdersDao;

	@Override
	public List<TomatoOrder> getTomatoOrders(int size) {
		System.out.println("Calling SERVICE");
		return tomatoOrdersDao.getOrders(size);
	}
	
}
