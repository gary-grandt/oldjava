package UEbungen;

public class $UE_0_1_Multithreading_Main {
	
	public static void main(String[] args) {
		$UE_0_1_Multithreading_Thread tread1 = new $UE_0_1_Multithreading_Thread("Fred_1");
		$UE_0_1_Multithreading_Thread tread2 = new $UE_0_1_Multithreading_Thread("Fred_2");
		
		tread1.start();
		tread2.start();
		
		try {
			tread1.join();
			tread2.join();
		}catch(InterruptedException e) {
			
		}
		
		System.out.println("Beende : Main");
	}
	
}
