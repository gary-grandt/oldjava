package Test;

import STD.Input;

public class ETR {
	private boolean run = true;
	private int in;
	private int r;
	private int z;
	private int base;
	Input input = new Input();
	public void main() {
		System.out.println("Biite geben sie die Base ein:");
		base = input.inInt();
		while(run) {
			System.out.println("Bitte geben sie die Zahl ein");
			in = input.inInt();
			
			r = in % base;
			System.out.println("R : " + r);
			z = in / base;
			System.out.println("Z : " + z);
			
			//Beenden?
			System.out.println("Wollen sie das Program beenden?");
			run = !input.inBoolean_com();
		}
	}
	
	public static void main(String arges[]) {
		ETR run = new ETR();
		run.main();
	}
}
