package javatechy.lambdas.subsitute;
import javatechy.lambdas.subsitute.EmailNotifier;
import javatechy.lambdas.subsitute.Notifier;

public class DifferenceFinder {

	public static void main(String[] args) {
		// Implementing Class
		Notifier emailNotifier = new EmailNotifier();
		emailNotifier.notifyMe();
		
		// Anonymous Class
		Notifier emailNotifierAc = new Notifier() {
			@Override
			public void notifyMe() {
				System.out.println("I m anonymous class and notifying you");
			}
		};
		emailNotifierAc.notifyMe();
		
		// Lambda Class
		Notifier emailNotifierFi = ()-> System.out.println("I m lambda and notifying you");
		emailNotifierFi.notifyMe();
	}
}
