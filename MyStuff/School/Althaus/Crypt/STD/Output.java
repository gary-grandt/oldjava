package Althaus.Crypt.STD;

public class Output {
	
	public void endLine() {
		System.out.println();
	}
	
	public void print(String output) {
		System.out.print(output);
	}
	
	public void println(String output) {
		System.out.println(output);
	}
	
	
	public void printInput(String output, int i) {
		switch(i) {
		case 2:
			System.out.print("  ==> " +output + " : ");
			break;
		case 3: 
			System.out.print("  --> " +output+ " : ");
		}
	}
	
	
	// print Comands
	
	public void printComand(String output, int i) {
		switch(i) {
		case 0:
			printTopLine(output);
			break;
		case 1:
			printComandLine(output);
			break;
		case 2:
			printSubComandLine(output);
			break;
		case 3:
			printUnderSubComandLine(output);
		}
	}
	
	public void printTopLine(String output) {
		int length = output.length();
		System.out.print("\n-----");
		for(int i = 0; i < length; i++) System.out.print("-");
		System.out.println("-----");
		
		System.out.println(" --- "+output+" --- ");
		
		System.out.print("-----");
		for(int i = 0; i < length; i++) System.out.print("-");
		System.out.println("-----\n");
	}
	
	public void printComandLine(String output) {
		System.out.println("\n _> "+output);
	}
	
	public void printSubComandLine(String output) {
		System.out.println("  ==> "+output);
	}
	
	public void printUnderSubComandLine(String output) {
		System.out.println("  --> "+output);
	}
	
	// Other
	
	public void printError(String output) {
		System.out.println("\n<!> Error : "+output);
	}
	
	public void printWarning(String output) {
		System.out.println("\n<!> Warning : "+output);
	}
}
