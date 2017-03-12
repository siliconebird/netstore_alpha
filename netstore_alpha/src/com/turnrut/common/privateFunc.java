package com.turnrut.common;

import com.turnrut.domain.Category;
import com.turnrut.service.BusinessService;
import com.turnrut.service.Impl.BusinessServiceImpl;

public class privateFunc {
	static BusinessService bs = new BusinessServiceImpl();
	public static String showNameById(String bookId){
		Category category = bs.findCategoryById(bookId);
		String name = category.getName();
		return name;
	}
}
