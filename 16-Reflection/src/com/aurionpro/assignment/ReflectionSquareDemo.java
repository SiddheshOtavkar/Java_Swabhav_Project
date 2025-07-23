package com.aurionpro.assignment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSquareDemo {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Create an object of MathUtil
        MathUtil obj = new MathUtil();

        // Get the class
        Class<?> cls = MathUtil.class;

        // Get the Method object for square(int)
        Method method = cls.getDeclaredMethod("square", int.class);

        // Invoke the method with argument 5
        Object result = method.invoke(obj, 5);

        // Print the result
        System.out.println("Result of square(5): " + result);
	}
}
