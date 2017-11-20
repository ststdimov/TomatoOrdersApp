package com.musala.orders.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.orders.model.TomatoOrder;
import com.musala.orders.repository.TomatoOrdersDao;

@Service
public class TomatoOrdersServiceImpl implements TomatoOrdersService{

	private static final Logger log = LoggerFactory.getLogger(TomatoOrdersServiceImpl.class);
	
	@Autowired 
	TomatoOrdersDao tomatoOrdersDao;

	@Override
	public List<TomatoOrder> getTomatoOrders(int size) {
		log.info("Called service with size parameter " + size);
		return tomatoOrdersDao.getOrders(size);
	}
	
}
