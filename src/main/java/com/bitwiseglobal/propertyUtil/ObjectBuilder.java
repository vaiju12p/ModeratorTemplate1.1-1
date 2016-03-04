package com.bitwiseglobal.propertyUtil;

import java.lang.reflect.Method;
import java.util.Properties;

public class ObjectBuilder {
	private static Properties properties;
	private String methodName;
	private Class<?> c;
	private Object o;
	private Method m;
	private String className;
	
	public ObjectBuilder(){
		properties=PropertyReader.getProperties();
		methodName=properties.getProperty("FunctionName");
		className=properties.getProperty("ClassName");
	}

	public static String getProjectName(){
		new ObjectBuilder();
		System.out.println( properties.getProperty("ProjectName"));
		return properties.getProperty("ProjectName");
	}
	public String evaluateEntryFunction(String a) {
		String result = "";
		try {
			System.out.println( properties.getProperty("ProjectName"));
			c=Class.forName(className);
			o=c.newInstance();
			m=c.getMethod(methodName,new Class[]{String.class});
			result=""+ m.invoke(o, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
}
