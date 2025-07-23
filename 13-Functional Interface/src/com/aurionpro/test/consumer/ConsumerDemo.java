package com.aurionpro.test.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		Consumer<String> consumer = (msg) -> System.out.println(msg.toUpperCase());
		consumer.accept("siddhesh");

		Consumer<List<String>> printList = (list) -> list.forEach(System.out::println);
		printList.accept(Arrays.asList("Siddhesh", "Nayan", "Prathamesh", "Aryan"));

		Consumer<String> printLen = (len) -> System.out.println("Length of String is: " + len.length());
		printLen.accept("Hello Everyone, Java is a programming language.");
	}
}
