class Myobject {
	private static Myobject myobject;

	private Myobject() {
		;
	}

	public static Myobject getInstance() {
		if (myobject != null) {
				;
		}else {
			try {
				Thread.sleep(3000);
				synchronized (Myobject.class) {
					myobject = new Myobject();
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}	
		return myobject;	
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		System.out.println(Myobject.getInstance().hashCode());
	}
}

public class Singleton2_sync2_err {
	public static void main(String[] args) {
		Mythread th1 = new Mythread();
		Mythread th2 = new Mythread();
		Mythread th3 = new Mythread();

		th1.start();
		th2.start();
		th3.start();
	}

}
