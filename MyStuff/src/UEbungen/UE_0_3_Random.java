package UEbungen;
import java.util.*;

public class UE_0_3_Random {
	// Variablen
	int[] zahlen;
	int zahlen_anzahl;
	
	// Scanner
	Scanner scanner = new Scanner(System.in);
	
	// Random
    private Random random = new Random();
    
    public void main() {
    	System.out.println("Wie viel Random Zahlen sollen ausgegeben werden?");
    	zahlen_anzahl = scanner.nextInt();
    	zahlen = new int[zahlen_anzahl];
    	//Arry fillUp
    	for(int i = 0; i < zahlen_anzahl; i++) {
    		zahlen[i] = random.nextInt();
    	}
    	//Ausgabe
    	for(int i = 0; i < zahlen_anzahl; i++) {
    		System.out.println(zahlen[i]);
    	}
    }
    
    public static void main(String[] args) {
    	UE_0_3_Random random_test = new UE_0_3_Random();
    	random_test.main();
    }
}
