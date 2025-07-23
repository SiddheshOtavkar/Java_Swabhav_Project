

interface MyIntf {
	static void greet() {
		System.out.println("Hello from interface");
	}
}

class Demo implements MyIntf {
	// This compiles, but it is NOT an override—just another static method
	static void greet() {
		System.out.println("Hello from class");
	}
}

public class StaticInterfacemethod {
	public static void main(String[] args) {
		MyIntf.greet(); // → Hello from interface
		Demo.greet(); // → Hello from class
	}
}
