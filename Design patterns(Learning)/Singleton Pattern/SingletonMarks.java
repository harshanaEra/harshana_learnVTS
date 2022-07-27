package singleton;

public class SingletonMarks {
	
	private static volatile SingletonMarks marks;
	
	private SingletonMarks () {
		if(marks != null) {
			throw new RuntimeException("Please use getMarks method");
		}
		
	}

	public static SingletonMarks getMarks() {
		
		if(marks == null) {
			synchronized (SingletonMarks.class) {
				if(marks == null) {
					marks = new SingletonMarks();
					countdown();
				}
			}
		}
		return marks;
	}
	
	public static void countdown() {
		for(int i = 10; i >= 0; i--) {
			System.out.println("Remaining time for the marks:" + i);
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==0) {
				System.out.println("Your time is ok now Thank you for waiting");
			}
		}
	}
	
	
		
}