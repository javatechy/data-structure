package annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
	String os() default "symbian";

	int version();
}

@SmartPhone(os = "andorid", version = 6)
class NokiaASeries {

	public String model;

	public NokiaASeries(String model) {
		this.model = model;
	}

}

public class CustomAnnotation {

	public static void main(String attop[]) {
		NokiaASeries nokiaASeries = new NokiaASeries("A900");
		Class nokiaASeriesClass = nokiaASeries.getClass();

		Annotation annotation = nokiaASeriesClass.getAnnotation(SmartPhone.class);
		SmartPhone sp = (SmartPhone) annotation;
		System.out.println(sp.os());
		System.out.println(sp.version());

	}
}
