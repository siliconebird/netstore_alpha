package com.turnrut.utils;

import java.io.File;

public class dirUtil {

	public static String mkdir(String storePath, String newFileName) {
		int fileHash = newFileName.hashCode();
		int dir1 = fileHash&0xf;
		int dir2 = (fileHash&0xf0)>>4;
		
		String subPath = "/"+dir1+"/"+dir2;
		File file = new File(storePath, subPath);
		if(!file.exists()){
			file.mkdirs();
		}
		return subPath;
	}
	
}
