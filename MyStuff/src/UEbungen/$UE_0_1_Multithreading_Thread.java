package UEbungen;

public class $UE_0_1_Multithreading_Thread extends Thread{
	String name;
	
	$UE_0_1_Multithreading_Thread(String con_name) {
		this.name = con_name;
		
	}
	
	public void run() {
		System.out.println("Starte Thread : " + name);
		
		
		System.out.println("Beende Thread : " + name);
	}
	
	
}
