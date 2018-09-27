package javatechy.lambdas.subsitute;

class EmailNotifier implements Notifier{
	@Override
	public void notifyMe() {
		System.out.println("I m in EmailNotifier notifying your for the mails");
	}
}
