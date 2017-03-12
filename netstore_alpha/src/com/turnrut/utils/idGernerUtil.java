package com.turnrut.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class idGernerUtil {

	public static String generId() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String str = df.format(date);			
		return str+System.nanoTime();
	}

}
