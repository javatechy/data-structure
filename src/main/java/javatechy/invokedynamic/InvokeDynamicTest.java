package javatechy.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvokeDynamicTest {

	public double instMethod(double value) {
		System.out.println("inst method called" + value);
		return value * 2;
	}

	public static void staticMethod(double value) {
		System.out.println("static Method called " + value);
	}

	public static void main(String[] args) throws Throwable {
		InvokeDynamicTest test = new InvokeDynamicTest();
		test.instMethod(2.0);
		test.staticMethod(4);
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle staticMethodHandle = lookup.findStatic(InvokeDynamicTest.class, "staticMethod", MethodType.methodType(void.class, double.class));
		staticMethodHandle.invoke(2.2);	
		// for further optimization - throws error if exact arguments not found
		// staticMethodHandle.invokeExact(2);	
		MethodHandle virtualMethodHandle = lookup.findVirtual(InvokeDynamicTest.class, "instMethod", MethodType.methodType(double.class, double.class));
		//virtualMethodHandle.invoke(test,2);
		virtualMethodHandle.bindTo(test).invoke(2);
		
		// using reflections 

	}

}
