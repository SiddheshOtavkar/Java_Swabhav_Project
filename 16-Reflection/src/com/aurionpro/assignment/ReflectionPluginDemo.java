package com.aurionpro.assignment;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionPluginDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class<?> cls = Plugin.class;

		// 2. Access private constructor
		Constructor<?> constructor = cls.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object obj = constructor.newInstance();

		// 3. Set private field 'version' = 3.1
		Field versionField = cls.getDeclaredField("version");
		versionField.setAccessible(true);
		versionField.set(obj, 3.1);

		// 4. Call execute() method
        Method executeMethod = cls.getDeclaredMethod("execute");
        executeMethod.setAccessible(true);
        executeMethod.invoke(obj);
        
        double version = (double) versionField.get(obj);
        System.out.println("Plugin version: " + version);
	}
}
