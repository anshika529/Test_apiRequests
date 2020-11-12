package com.atmecs.testapi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	
	Properties props;
	
	public PropReader(String filePath) {
		try {
			props = new Properties();
			props.load(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
}
