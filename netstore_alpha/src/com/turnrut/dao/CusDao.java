package com.turnrut.dao;

import com.turnrut.domain.Customer;

public interface CusDao {

	void save(Customer c);

	Customer findCusByKey(String keyCode);

	void updateCus(Customer c);

	Customer findCusByNamePw(String cusName, String cusPw);
	
	Customer findCusById(String cusId);
}
