package com.turnrut.service.Impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.turnrut.domain.Customer;

public class test {
	BusinessServiceImpl impl = new BusinessServiceImpl();
	@Test
	public void test() {
		Customer c = new Customer("1", "1", "1", "1", "1", "1", false, "1");
		impl.cusRigist(c);
	}
	@Test
	public void test2() {
		impl.cusActive("1");
	}
	@Test
	public void test3() {
		Object obj =  impl.cusLogin("1", "2");
		System.out.println(obj.toString());
	}
}
