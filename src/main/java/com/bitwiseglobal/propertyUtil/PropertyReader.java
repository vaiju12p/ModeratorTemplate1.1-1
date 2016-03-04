package com.bitwiseglobal.propertyUtil;

import java.util.Properties;

public class PropertyReader {
	private static Properties properties;

	private PropertyReader(){
		properties=new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("properties1.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Properties getProperties(){
		new PropertyReader();
		return properties;
		
	}
}
