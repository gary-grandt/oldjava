package Venediktov;

import STD.Input;

public class Start {
	public static void main(String[] args) {
		int in;
		int max = 2;
		Input input = new Input();
		System.out.println("Wich shuld be Startet?\n");
		System.out.println(" 01 Automat (GUI)");
		System.out.println(" 02 Crypt (GUI)");
		//System.out.println(" 0X ");
		
		in = input.inInt_com(1, max);
		
		switch(in) {
		case 1: 
			Venediktov.Automat.GUI.main(null);
			break;
		case 2: 
			Venediktov.Crypt.GUI.main(null);
			break;
		case 3: break;
		
		default: System.out.println("\nProject not fount!\n");
		}
		
		System.out.println("\n --- End --- \n");
	}
}
