package STD;
import java.util.Random;

public class RandomS {
	
	Random random = new Random();
	//random.nextInt(x-y)+y
	
	public int randInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}
	
	//public double randDouble(double min, double max, int nachKommer) {
	//	return (random.nextDouble() * ((max-min)+1))+min;
	//}
	
	public static void main(String[] args) {
		RandomS rand = new RandomS();
		for(int i = 0; i < 10; i++) {
			System.out.println(rand.randInt(3, 8));
		}
	}
}
