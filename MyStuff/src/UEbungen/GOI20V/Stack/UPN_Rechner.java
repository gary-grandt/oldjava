package UEbungen.GOI20V.Stack;

import java.util.Scanner;

import STD.Input;

public class UPN_Rechner {
	//Varibales
	private String inputString;
	//private String[] inputArray;
	
	//Objects 
	private Input input = new Input();
	private Scanner scanner = new Scanner(System.in);
	
	//Main
	private void main() {
		System.out.println("Bitte geben sid die rechen Kette ein : ");
		inputString = scanner.nextLine();
		
		String[] inArr = inputString.split(" ");
		
		System.out.println(inArr.length);	
		
		for(int i = 0; i < inArr.length; i++) {
			System.out.println(inArr[i]);
		}
		
	}
	
	//Methods
	private String[] inputZerlegen(String input) {
		return input.split(" ");
	}
	
	private void rechne() {
		
	}
	
	//Main_arges
	public static void main(String arges[]) {
		UPN_Rechner run = new UPN_Rechner();
		run.main();
	}
	
	
}
