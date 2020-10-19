package Althaus.Crypt.STD.Crypt;

import Althaus.Crypt.STD.Math;

public class Cesar {
	Math math = new Math();
	
	public byte[] encrypt(byte[] text, int inputKey, byte zSystem) {
		byte key;
		if(zSystem == 26) {
			key = math.mod(inputKey, (byte)26);
			
			for(int i = 0; i < text.length; i++) {
				text[i] = math.mod(text[i]+key, (byte)26);
			}
			
			return text;
		}else {
			return null;
		}
	}
	
	public byte[] decrypt(byte[] text, int inputKey, byte zSystem) {
		byte key;
		if(zSystem == 26) {
			key = math.mod(inputKey, (byte)26);
			
			for(int i = 0; i < text.length; i++) {
				text[i] = math.mod(text[i]-key, (byte)26);
			}
			
			return text;
		}else {
			return null;
		}
	}
}
