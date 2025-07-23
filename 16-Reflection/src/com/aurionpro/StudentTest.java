package com.aurionpro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StudentTest {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Student student = new Student();
		Class<?> c = Student.class;
		System.out.println("Class Name: " + c.getName());

//		System.out.println("\nFields are: ");
//		Field[] fields = c.getDeclaredFields();
//		for (Field res : fields) {
//			System.out.print(res.getName() + ",  ");
//		}
//
//		System.out.println();
//		System.out.print("\nMethods are: ");
//		for (Method methods : c.getDeclaredMethods()) {
//			System.out.println(methods.getName());
//			System.out.println("type " + methods.getReturnType());
//			System.out.println("Modifier: " + Modifier.toString(methods.getModifiers()));
//		}
//
//		System.out.println("\nConstructors are:");
//		for (Constructor<?> constructor : c.getDeclaredConstructors()) {
//			System.out.println("Constructor Name: " + constructor.getName());
//			System.out.println("Parameter Count: " + constructor.getParameterCount());
//			System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
//			System.out.println();
//		}

//		Field fields = c.getDeclaredField("cgpa");
//		
//		fields.setAccessible(true);
//		System.out.println("CGPA is: " + fields.get(student));
//		
//		Method method = c.getDeclaredMethod("result", double.class);
//		method.setAccessible(true);
//		
//		Object returnValue = method.invoke(student, 8.5);
//		System.out.println("Result method returned: " + returnValue);

		Field field = c.getDeclaredField("rollNumber");
		field.setAccessible(true);

		int value = field.getInt(student);
		System.out.println("Original roll number: " + value);
		
		field.set(student, 20);
		System.out.println("Modified roll number: " + field.getInt(student));
	}
}
