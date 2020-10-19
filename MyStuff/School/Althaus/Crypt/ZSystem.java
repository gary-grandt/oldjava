package Althaus.Crypt;

import Althaus.Crypt.STD.Output;
import java.math.BigInteger;
//import java.util.ArrayList;

public class ZSystem {
	/*
	 * In GG-Crypt werden die Zeichen intern als Bytes gespeichert.
	 * Dies ist ausreichend, da selbst bei der verwendung von ASCI (128 Zeichen),
	 * bei der Verschlüsselung nie höhere werte als 256 erreicht werden.
	 */
	
	// Variables
	private Output output = new Output(); // Output for Errors
	
	private boolean isClear = true;
	
	private byte[] chiffre;
	private BigInteger[] chiffreRSA;
	//private ArrayList<byte[]> keyList = new ArrayList<byte[]>();
	
	private String system;
	private byte systemNr = -1;
	
	// Methodes
	public void input(String input) {
		if(!isClear) {
			output.printError("Please clear!");
			return;
		}
		
		switch(systemNr) {
		case 26:
			chiffre = z26_StB(input);
			isClear = false;
			output.printComand("The String will breakup after an invalid input!", 2);
			break;
		default:
			output.printError("No Valid ZSystem is choosen!");
		}
	}
	
	public void clear() {
		chiffre = null;
		//keyList = new ArrayList<byte[]>();
		isClear = true;
	}
	
	public void changeSystem(byte newSystem) {
		if(newSystem == systemNr) return;
		
		switch(systemNr) {
		case 26:
			switch(newSystem) {
			case 127:
				System.out.println("To do! - change ZSystem");
				break;
			case -128:
				system = "RSA";
				systemNr = (byte) -128;
			}
			break;
		case 127:
			switch(newSystem) {
			case 26:
				output.printError("ZSystem can't changed down!");
				break;
			case -128:
				System.out.println("To Do!");
				break;
			}
			break;
		case -128:
			switch(newSystem) {
			case 26:
				system = "Z26";
				systemNr = -128;
				break;
			case 127:
				System.out.println("To Do!");
				break;
			}
		default:
			output.printError("System is not Valid!");
			systemNr = 26;
			system = "Z26";
		}
	}
	
	
	/* --- Geter && Seter --- */
	
	// System
	public String getSystem() {
		return system;
	}
	
	public byte getSystemNr() {
		return systemNr;
	}
	
	public void setSystem(byte input) {
		/*if(!isClear) {
			output.printError("Please clear, befor changing the System!");
		}*/
		switch(input) {
		case 26:
			system = "Z26";
			systemNr = 26;
			break;
		default:
			output.printError("Can't choose System");
		}
	}
	
	
	
	// --- Chiffre ---
	public byte[] getChiffre() {
		return chiffre;
	}
	
	public void setChiffre(byte[] input) {
		chiffre = input;
	}
	
	public String getChiffre_String() {
		if(isClear) {
			return "";
		}
		
		switch(systemNr) {
		case 26:
			return z26_BtS(chiffre);
		case 127:
			return zH7B_toString(chiffre);
		case -128:
			return zRSA_toString(chiffreRSA);
		default:
			output.printError("No Valid ZSystem is choosen!");
			return "";
		}
	}
	
	
	// Chiffre - RSA
	public BigInteger[] getChiffreRSA() {
		return chiffreRSA;
	}
	
	public void setChiffreRSA(BigInteger[] inputRSA) {
		chiffreRSA = inputRSA;
	}
	
	
	// --- Key ---
	public String getKeyList_String() {
		
		return "";
	}
	
	public boolean isClear() {
		return isClear;
	}
	
	
	
	/* --- Z-26 --- */
	
	public byte z26_CtB(char input) {
		switch(input) {
		case 'a': case 'A':
			return 0;
		case 'b': case 'B':
			return 1;
		case 'c': case 'C':
			return 2;
		case 'd': case 'D':
			return 3;
		case 'e': case 'E':
			return 4;
		case 'f': case 'F':
			return 5;
		case 'g': case 'G':
			return 6;
		case 'h': case 'H':
			return 7;
		case 'i': case 'I':
			return 8;
		case 'j': case 'J':
			return 9;
		case 'k': case 'K':
			return 10;
		case 'l': case 'L':
			return 11;
		case 'm': case 'M':
			return 12;
			
		case 'n': case 'N':
			return 13;
		case 'o': case 'O':
			return 14;
		case 'p': case 'P':
			return 15;
		case 'q': case 'Q':
			return 16;
		case 'r': case 'R':
			return 17;
		case 's': case 'S':
			return 18;
		case 't': case 'T':
			return 19;
		case 'u': case 'U':
			return 20;
		case 'v': case 'V':
			return 21;
		case 'w': case 'W':
			return 22;
		case 'x': case 'X':
			return 23;
		case 'y': case 'Y':
			return 24;
		case 'z': case 'Z':
			return 25;
		default: 
			output.printError("Conversion: Z-26:");
			output.printComand("Can't find char in Z26!", 2);
			return -1;
		}
	}
	
	public char z26_BtC(byte input) {
		switch(input) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		case 8:
			return 'I';
		case 9:
			return 'J';
		case 10:
			return 'K';
		case 11:
			return 'L';
		case 12:
			return 'M';

		case 13:
			return 'N';
		case 14:
			return 'O';
		case 15:
			return 'P';
		case 16:
			return 'Q';
		case 17:
			return 'R';
		case 18:
			return 'S';
		case 19:
			return 'T';
		case 20:
			return 'U';
		case 21:
			return 'V';
		case 22:
			return 'W';
		case 23:
			return 'X';
		case 24:
			return 'Y';
		case 25:
			return 'Z';
		default:
			output.printError("Conversion: Z-26:");
			output.printComand("Can't find byte in Z26!", 2);
			return ' ';
		}
	}
	
	public byte[] z26_StB(String inputString) {
		char[] input = inputString.toCharArray();
		byte[] output = new byte[inputString.length()];
		
		for(int i = 0; i < inputString.length(); i++) {
			if(input[i] != ' ') {
				output[i] = z26_CtB(input[i]);
			}
		}
		
		return output;
	}
	
	public String z26_BtS(byte[] input) {
		String output = "";
		
		for(int i = 0; i < input.length; i++) {
			output += z26_BtC(input[i]);
		}
		
		return output;
	}
	
	// To Hex 7-Bit
	
	
	
	/* --- Z-H7B --- */
	
	public String zH7B_toString(byte[] inputArray) {
		String output = "";
		for(byte current : inputArray) {
			output += String.format("%02X", current) +" ";
		}
		return output;
	}
	
	
	
	
	
	/* --- Z-RSA ---*/
	
	public String zRSA_toString(BigInteger[] array) {
		String output = "[";
		for(int i = 0; i < array.length; i++) {
			output += array[i].toString();
			
			if((i+1 < array.length)) {
				output += "],[";
			}
		}
		
		output += "]";
		return output;
	}
	
	public void zRSA_makeBlocks(int blockSize) {
		int charsPerBlock = (blockSize /8) -1;
		int blocksNeeded = 0;
		for(int i = chiffre.length; i > 0; i = i -charsPerBlock) blocksNeeded++;
		output.printComand("Chiffre (length) : " + chiffre.length, 3);
		output.printComand("Chars per Block  : " + charsPerBlock, 3);
		output.printComand("Blocks   needed  : " + blocksNeeded, 3);
		
		// --- MakeBlocks --- 
		chiffreRSA = new BigInteger[blocksNeeded];
		byte[][] blockChars = new byte[blocksNeeded][charsPerBlock]; 
		
		// Split into Bocks
		int counter = 0;
		for(int i = 0; i < blocksNeeded; i++) {
			for(int j = 0; j < charsPerBlock; j++) {
				if(counter < chiffre.length) {
					blockChars[i][j] = chiffre[counter];
				}else {
					blockChars[i][j] = -128;
				}
				counter++;
			}
		}
		
		// Pack the Blocks
		for(int i = 0; i < blocksNeeded; i++) {
			chiffreRSA[i] = new BigInteger(blockChars[i]);
		}
		
		
	}
	
	public void zRSA_unmakeBlocks() {
		int blocksCount = chiffreRSA.length;
		// RSA to Blocks
		byte[][] blocks = new byte[blocksCount][];
		for(int i = 0; i < blocksCount; i++) {
			blocks[i] = chiffreRSA[i].toByteArray();
		}
		// Megre Blocks
		chiffre = blocks[0];
		if(blocksCount != 1) {
			for(int i = 1; i < blocksCount; i++) {
				chiffre = mergeByteArrays(chiffre, blocks[i]);
			}
		}
	}
	
	
	
	// Tools
	public void printArray(byte[] output) {
		if(output == null) {
			System.out.println("Array: null");
		}else {
			for(int i = 0; i < output.length; i++) {
				System.out.println(i+" _> ");
				System.out.println(output[i]);
			}	
		}
	}
	
	private byte[] mergeByteArrays(byte[] one, byte[] tow) { 
		int length = one.length + tow.length;
		// Kick Fill elements
		for(int i = 0; i < tow.length; i++) if(tow[i] == -128) length--;
		
		byte[] output = new byte[length];
		
		for(int i = 0; i < length; i++) {
			if( i < one.length) {
				output[i] = one[i];
			}else {
				output[i] = tow[i -one.length];
			}
		}
		return output;
	}
	
	
	private void main() {
		
		byte[] a = {1,2,3,4,5,6};
		byte[] b = {7,8,9,-128, -128};
		
		byte[] c = mergeByteArrays(a, b);
		
		printArray(c);
	}
	
	public static void main(String[] args) {
		ZSystem run = new ZSystem();
		run.main();
	}
}











