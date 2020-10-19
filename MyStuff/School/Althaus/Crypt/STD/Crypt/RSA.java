package Althaus.Crypt.STD.Crypt;

import java.math.BigInteger;
import java.util.Random;
public class RSA {
	
	public BigInteger encrypt(BigInteger e, BigInteger n, BigInteger k) {
		return k.modPow(e, n);
	}
	
	public BigInteger decrypt(BigInteger d, BigInteger n, BigInteger k) {
		return k.modPow(d, n);
	}
	
	
	public boolean isValidBlockSize(int blockSize) {
		switch(blockSize) {
		case 32: return true;
		case 64: return true;
		case 128: return true;
		case 256: return true;
		case 512: return true;
		case 1024: return true;
		case 2048: return true;
		case 4096: return true;
		}
		return false;
	}
	
	
	public BigInteger[] generateKeyPair(int blockLength) {
		BigInteger p, q, n, phi, e, d;
		
		Random rnd = new Random();
		p = BigInteger.probablePrime(blockLength/2, rnd);
		q = BigInteger.probablePrime((blockLength/2)+1, rnd);
		
		n = p.multiply(q);
		phi = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		
		e = BigInteger.probablePrime(blockLength-2, rnd);
		d = e.modInverse(phi);
		
		BigInteger[] keyPair = {p, q, n, phi, e, d};
		return keyPair;
	}
	
	
}
