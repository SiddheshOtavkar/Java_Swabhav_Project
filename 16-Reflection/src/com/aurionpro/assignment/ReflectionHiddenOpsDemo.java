package com.aurionpro.assignment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHiddenOpsDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HiddenOps obj = new HiddenOps();
		
		Class<?> clas = HiddenOps.class;
		
		Method method = clas.getDeclaredMethod("secretCode", String.class);
		
		method.setAccessible(true);
		
		Object result = method.invoke(obj, "hello");
		
		System.out.println("Reversed: " + result);
	}
}
