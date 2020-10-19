package Games;
import java.util.*;

public class TowersOfHanoi{
    //Konstrucot
    public TowersOfHanoi() {}
    
    //Variablen
    private int scheiben_anzahl;
    private int[][] scheiben_array;
    private int[][] scheiben_array_lastStep;
    private int scheiben_bestel�sung;
    
    private int move_1;
    private int move_2;
    
    private int z�ge_gebraucht = 0;
    private int z�ge_l�sung;
    
    //Scanner
    private Scanner scanner = new Scanner(System.in);
    
    public void main(){
        
        System.out.println("Mit wie vielen Scheiben wollen sie spielen?");
        scheiben_anzahl = input_Int(1, 999999);
        
        z�ge_l�sung = (scheiben_anzahl * scheiben_anzahl) -1;
        if(scheiben_anzahl == 1) z�ge_l�sung = 1;
        
        //Array Creation
        scheiben_array = new int[3][scheiben_anzahl];
        scheiben_array_lastStep = new int[3][scheiben_anzahl];
        
        //Array FillUp
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < scheiben_anzahl; j++){
                if(i == 0){
                    scheiben_array[i][j] = j+1;
                }else{
                    scheiben_array[i][j] = 0;
                }
            }
        }
        
        //First Print 
        printTowers();
        
        //Abfrage, if you would like self to Play, or genrate the Soluttion
        System.out.println("Wollen sie selbst spielen [true] oder eine L�sung Gennerien [false]?");
        if(scanner.nextBoolean()){
            selfPlay();
        }else{
            generateSolution();
        }
    }
    
    //-----------------
    //--- Self Play ---
    //-----------------
    private void selfPlay() {
        
        int stab_1;
        int stab_1_height;
        int stab_2;
        int stab_2_height;
        
        int bewegungsError;
        
        //Spielerk�rung
        System.out.println("Das Spiel funktioniert Volgendermassen : ");
        System.out.println("Unter 'Stab : 1' geben sie an von welchen Stab sie eine Scheibe bewegen m�schten.");
        System.out.println("Unter 'Stab : 2' geben sie an zue welchen Stab sie eine Scheibe bewegen m�schten.");
        System.out.println("Es kann immer nur die Oberstescheibe bewegt werden!");
        System.out.println("Es k�nnen immer nur kleiner auf gr��ere Scheiben gelegt werden!");
        
        //Spiel
        while(!fertig()) {
            printTowers();
            
            System.out.println("Stab 1 : ");
            stab_1 = input_Int(1, 3) -1;
            System.out.println("Stab 2 : ");
            stab_2 = input_Int(1, 3) -1;
            
            bewegungsError = bewegeScheibe(stab_1, stab_2);
            if(bewegungsError == -1){
                System.out.println("Auf Stab : " + stab_1+1 + " befindet sich keine Scheibe!     Error: 1/-1");
            }else if(bewegungsError == -2) {
                System.out.println("Die Scheibe, welche bewegt werden soll ist kleiner als die Oberste scheibe auf dem Zielstab!    Error: 1/-2");
            }else if(bewegungsError == -3) {
                System.out.println("Bewege scheiben Zielposition ausserhalb des Arrays!    Error: 1/-3");
            }else {
                z�ge_gebraucht++;
            }
        }
        //Becaus it's not a doWhile-loop
        z�ge_gebraucht++;
        //Letzt Ausgabe, mit Ergebnis
        printTowers();
        System.out.println("Du hast : " + z�ge_gebraucht + " z�ge gebraucht! ");
        System.out.println("Die bestm�gliche l�sung ligt bei : " + z�ge_l�sung + " z�gen!");
    }
    
    //------------------------
    //--- Genrate Solution ---
    //------------------------
    private void generateSolution() {
        int scheibe;
        int stab;
        int stab_height;
        int ausweichen;
        for(int i = scheiben_anzahl; i > 0; i--){
            scheibe = i;
            stab = findScheibe_stab(scheibe);
            stab_height = findScheibe_height(stab, scheibe);
            if(stab == 0){
                ausweichen = 1;
            }else{
                ausweichen = 0;
            }
            l�se(stab_height, stab, 2, ausweichen);
            delay(720);
        }
        System.out.println("Die bestm�gliche l�sung ligt bei : " + z�ge_l�sung + " z�gen!");
        //System.out.println("Diese automatisch generiete L�sung braucht : " + z�ge_gebraucht + " z�g. ");
        //Da es bei der automatischen Generierung zu Dopplungen kommen kann, ein Beispiel f�r diese w�ren:
        //Die Vorletzten beiden z�ge bei 2 Scheiben!
    }
    
    private void l�se(int height_self, int stab_self, int stab_ziel, int stab_ausweichen) {
        //z�ge_gebraucht++;
        if(canMove(height_self, stab_self, stab_ziel) == 1) {
            //Scheibe wird bewegt
            int bewge = bewegeScheibe(stab_self, stab_ziel);
            if(bewge != 0) System.out.println("Error: 2/-2    !Scheibe can't Move!");
        } else if(canMove(height_self, stab_self, stab_ziel) == 2){
            //Scheibe wird selbst noch von einer anderen belegt
            l�se(height_self -1, stab_self, stab_ausweichen, stab_ziel);
            l�se(height_self, stab_self, stab_ziel, stab_ausweichen);
        }else if(canMove(height_self, stab_self, stab_ziel) == 3) {
            //Scheibe ist auf Ziel und wir nach Ausweichen bewegt,
            //Auf einen selbst befindet sich keine Scheibe
            int height = obersteScheibe(stab_ziel);
            l�se(height, stab_ziel, stab_ausweichen, stab_self);
            l�se(height_self, stab_self, stab_ziel, stab_ausweichen);
        }else if(canMove(height_self, stab_self, stab_ziel) == -1) {
            System.out.println("Error: 2/-1     !ConMove_NotWork!");
        }
        System.out.println("");
        printTowers();
    }
    
    private int canMove(int height_self, int stab_self, int stab_ziel) {
        int stab_self_height = obersteScheibe(stab_self);
        int stab_ziel_height = obersteScheibe(stab_ziel);
        
        int scheibe_self = scheiben_array[stab_self][stab_self_height];
        int scheibe_ziel = scheiben_array[stab_ziel][stab_ziel_height];
        
        if(height_self == stab_self_height && (scheibe_self < scheibe_ziel || scheibe_ziel == 0)) {
            //System.out.println("Return : 1");
            return 1;
        }else if(height_self > stab_self_height) {
            //System.out.println("Return : 2");
            return 2;
        }else if(scheibe_self > scheibe_ziel && scheibe_ziel != 0) {
            //System.out.println("Return : 3");
            return 3;
        }
        return -1;
    }
    
    private int findScheibe_stab(int scheibe) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < scheiben_anzahl; j++){
                if(scheiben_array[i][j] == scheibe) return i;
            }
        }
        return -1;
    }
    
    private int findScheibe_height(int stab, int scheibe) {
        for(int i = 0; i < scheiben_anzahl; i++) {
            if(scheiben_array[stab][i] == scheibe) return i;
        }
        return -1;
    }
    
    //-------------------
    //--- Both needed ---
    //-------------------
    private int bewegeScheibe(int stab_1, int stab_2) {
        int stab_1_height = obersteScheibe(stab_1);
        int stab_2_height = obersteScheibe(stab_2);
        if(stab_1_height == -1) return -1;                          //Error Type: 1/-1
        if(stab_2_height == -3) return-3;                           //Error Type: 1/-3
        
        int scheibe_1 = scheiben_array[stab_1][stab_1_height];
        int scheibe_2 = scheiben_array[stab_2][stab_2_height];
        if(!(scheibe_1 < scheibe_2) && scheibe_2 != 0) return -2;      //Error Type: 1/-2
        
        scheiben_array[stab_1][stab_1_height] = 0;
        if(scheibe_2 == 0) scheiben_array[stab_2][stab_2_height] = scheibe_1;
        if(scheibe_2 != 0) scheiben_array[stab_2][stab_2_height -1] = scheibe_1;
        return 0;
    }
    
    private int obersteScheibe(int stab) {
        for(int i = 0; i < scheiben_anzahl; i++) {
            if(scheiben_array[stab][i] != 0 || i == scheiben_anzahl-1) {
                return i;
            }
        }
        return-3;
    }
    
    private boolean fertig() {
        for(int i = 0; i < scheiben_anzahl; i++) {
            if(scheiben_array[2][i] != (i+1)){
                return false;
            }
        }
        return true;
    }
    
    //------------------------------
    //--- Ausgabe in der Konsole ---
    //------------------------------
    private void printTowers() {
        //F�r denn Fall das es mehr als 8 Scheiben gibt, wird die Darstellung angepasst
        //if(isDouble()) {
        //}else
        if(scheiben_anzahl <= 8) {
            printTowers_lesseEqual8();
        }else {
            System.out.println("Turm : 1");
            printTowers_over8(0);
            System.out.println("Turm : 2");
            printTowers_over8(1);
            System.out.println("Turm : 3");
            printTowers_over8(2);
            
        }
        //scheiben_array_lastStep = scheiben_array.clone();
    }
    
    //Bei bis zu 8 Scheiben
    private void printTowers_lesseEqual8() {
        for(int j = 0; j < scheiben_anzahl; j++) {
            for(int i = 0; i < 3; i++) {
                printTowers_TowerSection(scheiben_array[i][j]);
            }
            System.out.print("\n");
        }
    }
    //Eine Sektion eines Turms wird ausgegben
    private void printTowers_TowerSection(int scheiben_lenght) {
        int lenge = scheiben_anzahl - scheiben_lenght;
        for(int i = 0; i < lenge; i++) {
            System.out.print(" ");
        }
        for(int i = 0; i < scheiben_lenght; i++) {
            System.out.print("-");
        }
        System.out.print("|");
        for(int i = 0; i < scheiben_lenght; i++) {
            System.out.print("-");
        }
        for(int i = 0; i < lenge; i++) {
            System.out.print(" ");
        }
    }
    
    //Bei mehr als 8 Scheiben
    private void printTowers_over8(int turm) {
        for(int i = 0; i < scheiben_anzahl; i++){
            if(scheiben_array[turm][i] != 0) {
                System.out.print(" " + scheiben_array[turm][i] + ";");
            }
        }
        System.out.println("");
    }
    
    //Umf�r die Automatische Genration vor zubeugen, das Schritte Doppelt ausgegeben werden!
    private boolean isDouble() {
        if(Arrays.deepEquals(scheiben_array, scheiben_array_lastStep)) return true; 
        return false;
    }
    
    //--------------
    //--- Inputs ---
    //--------------
    private int input_Int(int range_1, int range_2) {
        boolean finish = false;
        int input = -1;
        while(!finish){
            input = scanner.nextInt();
            if(!(input >= range_1 && input <= range_2)){
                System.out.println("Input : " + input + " is out of range!");
                System.out.println("Min: " + range_1);
                 System.out.println("Max: " + range_2);
            }else finish = true;
        }
        return input;
    }
    
    //------------
    //--- Main ---
    //------------
    public static void main(String[] arges) {
    	TowersOfHanoi ausf�hren = new TowersOfHanoi();
        ausf�hren.main();
    }
    
    private void delay(int delay_time) {
        try {
            Thread.sleep(delay_time);
        }catch(java.lang.InterruptedException iex){
        
        }
    }
}

//--------------
//--- Errors ---
//--------------

//--- SelfPlay ---
//Error: 1/-1
//Auf Ausgansstab befindet sich keine Scheibe!

//Error_1/-2
//Die Scheibe, welche bewegt werden soll ist kleiner als die Oberste scheibe auf dem Zielstab!

//Error: 1/-3
//Bewege scheiben Zielposition ausserhalb des Arrays!

//--- GenerateSolution ---
//Error: 2/-1
//Der Aufruf der Funktion 'ConMove', von der funktion 'l�se' findet keine G�ltigen Werte!

//Error: 2/-2
//Der Aufruf der Funktion 'bewegeScheibe', von der funktion 'l�se' konnte nicht ausgef�hrt werden!