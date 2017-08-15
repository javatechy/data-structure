package javatechy.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class DynamicTest {

	public double instMethod(double value) {
		System.out.println("inst method called" + value);
		return value * 2;
	}

	public static void staticMethod(double value) {
		System.out.println("static Method called " + value);
	}

	public static void main(String[] args) throws Throwable {
		DynamicTest test = new DynamicTest();
		test.instMethod(2.0);
		test.staticMethod(4);
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle staticMethodHandle = lookup.findStatic(DynamicTest.class, "staticMethod", MethodType.methodType(void.class, double.class));
		staticMethodHandle.invoke(2.2);	
		// for further optimization - throws error if exact arguments not found
		// staticMethodHandle.invokeExact(2);	
		MethodHandle virtualMethodHandle = lookup.findVirtual(DynamicTest.class, "instMethod", MethodType.methodType(double.class, double.class));
		//virtualMethodHandle.invoke(test,2);
		virtualMethodHandle.bindTo(test).invoke(2);
		
		// using reflections & invoke dynamic both
		Method instMethod =  DynamicTest.class.getMethod("instMethod", double.class);
		MethodHandle unreflect = lookup.unreflect(instMethod);
		unreflect.bindTo(test).invoke(5);
		
		

	}

}
