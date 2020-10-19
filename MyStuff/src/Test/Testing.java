package Test;

public class Testing {
	//Variables
	private int x = 9;
	private int y;
	
	//main
	private void main() {
		y = (int) Math.sqrt(x);
		System.out.println(" X : " + x + " Y : " + y);
	}
	
	//Start
	public static void main(String arges[]) {
		Testing run = new Testing();
		run.main();
	}
}
