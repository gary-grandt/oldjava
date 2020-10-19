package Althaus.Crypt;

import java.math.BigInteger;

import Althaus.Crypt.STD.*;
import Althaus.Crypt.STD.Math;
import Althaus.Crypt.STD.Crypt.*;

public class GGCrypt {
	private Input input = new Input();
	private Output output = new Output();
	private Math math = new Math();
	
	private boolean end = false;
	private String in;
	private ZSystem zsystem = new ZSystem();
	
	private void main() {
		output.printComand("GG-Crypt", 0);
		
		
		
		while(!end) {
			output.printComandLine("--- Pleas enter your input! ---");
			output.printSubComandLine("Z-System : " + zsystem.getSystem());
			output.printSubComandLine("Chiffre  : " + zsystem.getChiffre_String());
			output.printSubComandLine("KeyList  : " + zsystem.getKeyList_String());
			output.endLine();
			output.print(" _> ");
			
			in = input.in();
			verarbeitung(in);
			
		}
	}
	
	private void verarbeitung(String in) {
		switch(in) {
		case "-1":case "end":
			end = true;
			break;			
		case "0":case "00":case "help":
			help();
			break;
		case "1":case "01":case "zsystem":
			changeZSystem();
			break;
		case "2": case "02": case "clear":
			clearSeesion();
			break;
		case "3": case "03": case "load":
			loadSeesion();
			break;
		case "4": case "04": case "save":
			saveSeesion();
			break;
		case "5": case "05": case "input":
			inputSeesion();
			break;
		case "6": case "06": case "autoEncrypt":
			autoEncrypt();
			break;
		case "7": case "07": case "autoDecrypt":
			autoDecrypt();
			break;
		case "8": case "08": case "changePath":
			changePath();
			break;
		case "9": case "09": case "encrypt":
			encrypt();
			break;
		case "10": case "decrypt":
			decrypt();
			break;
		default: 
			output.printError("Invalid Input!");
			output.printComand("00 : help ", 2);
		}
	}
	
	// Methodes
	
	// 00 - help
	private void help() {
		output.printComand("Help : ", 1);
		output.printComand("-1 end", 2);
		output.printComand("00 Help", 2);
		output.printComand("01 Change Z-System", 2);
		output.printComand("02 Clear Session", 2);
		output.printComand("03 >Load Session", 2);
		output.printComand("04 >Save Session", 2);
		output.printComand("05 Input Session", 2);
		output.printComand("06 Auto Encrypt File", 2);
		output.printComand("07 Auto Decrypt File", 2);
		output.printComand("08 Change Path", 2);
		output.printComand("09 Encrypt", 2);
		output.printComand("10 Decrypt", 2);
		/*
		output.endLine();
		output.printComand("10 Encrypt Ceasar : ", 2);
		output.printComand("20 Decrypt Ceasar : ", 2);
		output.endLine();
		output.printComand("11 Encrypt Rot-X : ", 2);
		output.printComand("21 Decrypt Rot-X : ", 2);
		output.endLine();
		output.printComand("12 Encrypt Vigenere : ", 2);
		output.printComand("22 Decrypt Vigenere : ", 2);
		output.endLine();
		output.printComand("13 Encrypt Alberti-Chiffre : ", 2);
		output.printComand("23 Decrypt Alberti-Chiffre : ", 2);
		output.endLine();
		output.printComand("14 Encrypt Multiplikative-Chiffre : ", 2);
		output.printComand("24 Decrypt Multiplikative-Chiffre : ", 2);
		output.endLine();
		output.printComand("15 Encrypt Polybios : ", 2);
		output.printComand("25 Decrypt Polybios : ", 2);
		output.endLine();
		output.printComand("16 Encrypt Playfair : ", 2);
		output.printComand("26 Decrypt Playfair : ", 2);
		output.endLine();
		output.printComand("17 Encrypt Mega-Buck : ", 2);
		output.printComand("27 Decrypt Mega-Buck : ", 2);
		output.endLine();
		output.printComand("18 Encrypt Nihilisten-Transposition : ", 2);
		output.printComand("28 Decrypt Nihilisten-Transposition : ", 2);
		output.endLine();
		output.printComand("19 Encrypt Nihilisten-Substitution : ", 2);
		output.printComand("29 Decrypt Nihilisten-Substitution : ", 2);

		output.endLine();
		output.printComand("30 Encrypt Bifid-Chiffre : ", 2);
		output.printComand("40 Decrypt Bifid-Chiffre : ", 2);
		output.endLine();
		output.printComand("31 Encrypt Diffie-Hellman : ", 2);
		output.printComand("41 Decrypt Diffie-Hellman : ", 2);
		output.endLine();
		output.printComand("32 Encrypt Hill : ", 2);
		output.printComand("42 Decrypt Hill : ", 2);
		output.endLine();
		output.printComand("33 Encrypt RSA : ", 2);
		output.printComand("43 Decrypt RSA : ", 2);
		*/
	}
	
	// 01 - Change Z-System
	private void changeZSystem() {
		output.printComand("Change Z-System : " + zsystem.getSystem(), 1);
		// Output available Systems
		output.printComand("01 _> Z26", 2);
		//output.printComand("0 _> ", 2);
		
		// input the new System
		output.print(" _> ");
		byte in = input.inByte_com((byte)1, (byte)1);
		
		switch(in) {
		case 1:
			zsystem.setSystem((byte) 26);
			break;
		default:
			output.printError("Can't choose System!");
		}
	}
	
	// 02 - Clear Seesion
	private void clearSeesion() {
		output.printComand("Did you really want to clear the Seesion? (y/n)", 1);
		if(input.inBoolean_com()) {
			zsystem.clear();
		}
	}
	
	// 03 - Load Seesion
	private void loadSeesion() {
		output.printComand("Coming sone!", 1);
	}
	
	// 04 - Save Seesion
	private void saveSeesion() {
		output.printComand("Coming sone!", 1);
	}
	
	// 05 - Input Seesion
	private void inputSeesion() {
		output.printComand("Plaese enter your Text : ", 1);
		output.print(" ==>");
		zsystem.input(input.in());
	}
	
	// 06 - Auto Encrypt File
	private void autoEncrypt() {
		output.printComand("Coming sone!", 1);
	}
	
	// 07 - Auto Decrypt File
	private void autoDecrypt() {
		output.printComand("Coming sone!", 1);
	}
	
	// 08 - Change Path
	private void changePath() {
		output.printComand("Coming sone!", 1);
	}
	
	// 09 - Encrypt 
	private void encrypt() {
		output.printComand("Encrypte : ",1);
		output.endLine();
		output.printComand("-1 BreakUp",2);
		//output.printComand("00 Diffie-Hellman Key-Exchange",2);
		//output.endLine();
		output.printComand("01 Cesar / Rot-X",2);
		output.printComand("02 Vigenere",2);
		output.printComand("03 Multiplikative Chiffre",2);
		//output.printComand("04 Polybios",2);
		//output.printComand("05 MegaBuck",2);
		output.endLine();
		//output.printComand("06 Bifid Chiffre",2);
		//output.printComand("07 Playfair",2);
		//output.printComand("08 Nihilisten-Subsrirution",2);
		//output.printComand("09 Nihilisten-Transposition",2);
		//output.printComand("10 Hill",2);
		output.printComand("11 RSA",2);
		output.endLine();
		output.print("  ==> ");
		byte in = input.inByte_com((byte)-1, (byte)11);
		switch(in) {
		case -1: return;
		case 00: return;
		
		case 1: encryptCesar();
			break;
		case 2: encryptVigenere();
			break;
		case 3: encryptMultiplikativeChiffre();
		case 4: return;
		case 5: return;
		
		case 6: return;
		case 7: return;
		case 8: return;
		case 9: return;
		case 10: return;
		
		case 11: encryptRSA();
			break;
		}
	}
	
	// 10 - Decrypt
	private void decrypt() {
		output.printComand("Decrypte : ",1);
		output.endLine();
		output.printComand("-1 BreakUp",2);
		output.printComand("00 Diffie-Hellman Key-Exchange",2);
		//output.endLine();
		output.printComand("01 Cesar / Rot-X",2);
		output.printComand("02 Vigenere",2);
		output.printComand("03 Multiplikative Chiffre",2);
		//output.printComand("04 Polybios",2);
		//output.printComand("05 MegaBuck",2);
		output.endLine();
		//output.printComand("06 Bifid Chiffre",2);
		//output.printComand("07 Playfair",2);
		//output.printComand("08 Nihilisten-Subsrirution",2);
		//output.printComand("09 Nihilisten-Transposition",2);
		//output.printComand("10 Hill",2);
		output.printComand("11 RSA",2);
		output.endLine();
		output.print("  ==> ");
		byte in = input.inByte_com((byte)-1, (byte)11);
		switch(in) {
		case -1: return;
		case 00: return;
		
		case 1: decryptCesar();
			break;
		case 2: decryptVigenere();
			break;
		case 3: decryptMultiplikativeChiffre();
		case 4: return;
		case 5: return;
		
		case 6: return;
		case 7: return;
		case 8: return;
		case 9: return;
		case 10: return;
		
		case 11: decryptRSA();
			break;
		}
	}
	
	
	// --- Mehodes - Crypt ---
	
	// Cesar
	private void encryptCesar() {
		Cesar cesar = new Cesar();
		
		output.printComand("Encrypt Cesar : ",1);
		output.printComand(zsystem.getChiffre_String(),2);
		
		output.print("  ==> Key : ");
		int key = input.inInt();
		
		zsystem.setChiffre(cesar.encrypt(zsystem.getChiffre(), key, zsystem.getSystemNr()));
		
		output.printComand(zsystem.getChiffre_String(),2);
	}
	
	private void decryptCesar() {
		Cesar cesar = new Cesar();
		
		output.printComand("Encrypt Cesar : ",1);
		output.printComand(zsystem.getChiffre_String(),2);
		
		output.print("  ==> Key : ");
		int key = input.inInt();
		
		zsystem.setChiffre(cesar.decrypt(zsystem.getChiffre(), key, zsystem.getSystemNr()));
		
		output.printComand(zsystem.getChiffre_String(),2);
	}
	
	// Vigenere
	private void encryptVigenere() {
		Vigenere vigenere = new Vigenere();
		
		output.printComand("Encrypt Vigenere : ("+zsystem.getSystemNr()+") ", 1);
		output.printComand(zsystem.getChiffre_String(), 2);
		
		byte[] key = inputKey();
		
		zsystem.setChiffre(vigenere.encrypt(zsystem.getChiffre(), key, zsystem.getSystemNr()));
		
	}
	
	private void decryptVigenere() {
		Vigenere vigenere = new Vigenere();
		
		output.printComand("Encrypt Vigenere : ("+zsystem.getSystemNr()+") ", 1);
		output.printComand(zsystem.getChiffre_String(), 2);
		
		byte[] key = inputKey();
		
		zsystem.setChiffre(vigenere.decrypt(zsystem.getChiffre(), key, zsystem.getSystemNr()));
	}
	
	// Multiplikative-Chiffre
	private void encryptMultiplikativeChiffre() {
		MultiplikativeChiffre mult = new MultiplikativeChiffre();
		
		output.printComand("Encrypt Multiplikative-Chiffre : ", 1);
		output.printComand("Enter an Prime between 26 and 128 (System will chagne to H7B (Hex-7Bit)",2);
		output.printComand("Enter 26 to Stay in Z26 (Only a few modInverse)",2);
		byte m;
		do {
			output.printInput("m", 2);
			m = input.inByte();
			if(m != 26 || !math.isPrime(m)) break;
		}while(true);
		
		byte k;
		byte i;
		// Split on 26; get Inverse; encryptMultiplikativeChiffre;
		if(m == 26) {
			do {
				output.printInput("Zahl k", 2);
				k = input.inByte();
			}while(math.modInverse_z26(k) == -1);
			
			// Get Inverse
			i = math.modInverse_z26(k);
			output.printComand("Inverse i : "+i,2);
			
			zsystem.setChiffre(mult.encrypt(zsystem.getChiffre(), k, m));
			zsystem.printArray(zsystem.getChiffre());
			
		}else {
			
		}
	}
	
	private void decryptMultiplikativeChiffre() {
		
	}
	
	
	
	// RSA
	private void encryptRSA() {
		RSA rsa = new RSA();
		int blockSize = -1;
		
		output.printComand("Encrypt RSA : ", 1);
		output.printWarning("This will Change the ZSystem to RSA Blocks you can't encrypt anymore after this! (-1 for BreakUP)");
		do {
			output.print(" ==> BockSize (min 32, max 4096) : ");
			blockSize = input.inInt();
			if(blockSize == -1) return;
		}while(!rsa.isValidBlockSize(blockSize));
		
		// Change ZSystem
		zsystem.changeSystem((byte) -128);
		
		// Make Blocks
		zsystem.zRSA_makeBlocks(blockSize);
		output.printComand("Blocks : "+zsystem.getChiffre_String(), 2);
		
		// Key
		BigInteger p, q, n, phi, e, d;
		
		output.printInput("Did you want to generate a KeyPair?",2);
		if(input.inBoolean_com()) {
			BigInteger[] keyPair = rsa.generateKeyPair(blockSize);
			output.printComand("New KeyPair : ",2);
			p = keyPair[0];
			output.printComand("p : " +p.toString(),3);
			q = keyPair[1];
			output.printComand("q : " +q.toString(),3);
			n = keyPair[2];
			output.printComand("n : " +n.toString(),3);
			phi = keyPair[3];
			output.printComand("phi : " +phi.toString(),3);
			e = keyPair[4];
			output.printComand("e : " +e.toString(),3);
			d = keyPair[5];
			output.printComand("d : " +d.toString(),3);
		}else {
			output.printComand("Enter Key: ",2);
			output.printInput("n : ",3);
			n = new BigInteger(input.in());
			output.printInput("e : ",3);
			e = new BigInteger(input.in());
		}
		
		// Encrypt
		BigInteger[] k = zsystem.getChiffreRSA();
		for(int i = 0; i < k.length; i++) {
			k[i] = rsa.encrypt(e, n, k[i]);
		}
		zsystem.setChiffreRSA(k);
	}
	
	private void decryptRSA() {
		RSA rsa = new RSA();
		
		output.printComand("Decrypt RSA : ", 1);
		//output.printInput("Old ZSystem", 2);
		//byte oldSystem = input.inByte_com((byte)26, (byte)127);
		//output.endLine();
		//zsystem.changeSystem(oldSystem);
		
		// Decrypt 
		BigInteger d, n;
		output.printInput("d",3);
		d = new BigInteger(input.in());
		output.printInput("n",3);
		n = new BigInteger(input.in());
		
		BigInteger[] k = zsystem.getChiffreRSA();
		for(int i = 0; i < k.length; i++) {
			k[i] = rsa.decrypt(d, n, k[i]);
		}
		zsystem.setChiffreRSA(k);
		output.printComand("RSA : " + zsystem.zRSA_toString(zsystem.getChiffreRSA()), 2);
		
		// RSA to old-ZSystem
		zsystem.zRSA_unmakeBlocks();
		
		zsystem.setSystem((byte)26);
		
	}
	
	// --- Methodes - Other ---
	
	// input Key
	private byte[] inputKey() {
		String inputString;
		byte[] key;
		
		output.print("  ==> Key : ");
		inputString = input.in();
		
		switch(zsystem.getSystemNr()) {
		case 26:
			key = zsystem.z26_StB(inputString);
			break;
		default: 
			output.printError("Chosse System!");
			return null;
		}
		
		return key;
	}
	
	
	public static void main(String[] args) {
		GGCrypt run = new GGCrypt();
		run.main();
	}
}
