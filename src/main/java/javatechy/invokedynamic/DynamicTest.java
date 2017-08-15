package javatechy.invokedynamic;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;

public class DynamicTest {

	private static MethodHandle tickHandle;
	private static MethodHandle tockHandle;

	public static void tick() {
		System.out.println("tick called");
	}

	public static void tock() {
		System.out.println("tock called");
	}

	public static void main(String[] args) throws Throwable {
		CallSite callSite = callMeMethod();
		// DynamicTest test = new DynamicTest();
		//MethodHandle handler = callSite.getTarget();
		MethodHandle handler = callSite.dynamicInvoker();
		for (int i = 0; i < 10; i++) {
			handler.invoke();
			Thread.sleep(1000);
			changeHandle(callSite, i);
		}
		// IntStream.range(0, 11).forEach(i->handler.invoke());
	}

	private static void changeHandle(CallSite callSite, int index) throws NoSuchMethodException, IllegalAccessException {
		if (callSite.getTarget().equals(tickHandle)) {
			callSite.setTarget(tockHandle);
		} else {
			callSite.setTarget(tickHandle);
		}
		if(index==8){
			Runnable runnable =  ()-> System.out.println("Runnable thread handler");
			MethodHandles.Lookup  lookup =  MethodHandles.lookup();
			MethodHandle handler = lookup.findVirtual(runnable.getClass(), "run", MethodType.methodType(void.class));
			handler.bindTo(runnable);
			
		}
	}

	private static CallSite callMeMethod() throws NoSuchMethodException, IllegalAccessException {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		tickHandle = lookup.findStatic(DynamicTest.class, "tick", MethodType.methodType(void.class));
		tockHandle = lookup.findStatic(DynamicTest.class, "tock", MethodType.methodType(void.class));
		return new MutableCallSite(tickHandle);
	}

}
