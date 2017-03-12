package com.turnrut.dao;

import java.util.List;

import com.turnrut.domain.Order;

public interface OrderDao {

	void save(Order order);

	void update(Order order);

	Order getById(String orderId);

	List<Order> getByCusId(String cusId);

	Order getByNum(String num);

	void removeOder(String delOrderId);

	

}
