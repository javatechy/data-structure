package utils;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadPoolExample {

	static Logger logger = Logger.getLogger("mylogger");
	private static final int THREAD_POOL_SIZE = 3;
	static Integer VOTE_COUNT = 0;
	private static final String VOTE_CURL = "curl -X POST -F 'contestantId=5' -F 'validate=0' https://www.voot.com/bigg-boss/biggboss11/bb11/submit-voting";

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		for (int i = 0; i <= 20000; i++) {
			executor.execute(() -> {
				voteBB();
			});
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads" + VOTE_COUNT);
	}

	private static void print(Object str) {
		// logger.info(str.toString());
	}

	static String convertStreamToString(java.io.InputStream is) {
		@SuppressWarnings("resource")
		java.util.Scanner s = new Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	private static void voteBB() {
		try {

			String homeDirectory = System.getProperty("user.home");
			Process process;
			process = Runtime.getRuntime().exec(String.format(VOTE_CURL, homeDirectory));
			int exitCode = process.waitFor();
			print(exitCode);
			String result = convertStreamToString(process.getInputStream());
			print(result);
			synchronized (ThreadPoolExample.VOTE_COUNT) {
				ThreadPoolExample.VOTE_COUNT++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
