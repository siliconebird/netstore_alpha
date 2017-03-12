package com.turnrut.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FillBeanUtil {

	public static <T> T fillBean(HttpServletRequest request,Class<T> clazz){
		 try {
			T obj = clazz.newInstance();
			BeanUtils.copyProperties(obj, request.getParameterMap());
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
