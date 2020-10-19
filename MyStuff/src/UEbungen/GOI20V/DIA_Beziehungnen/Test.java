package UEbungen.GOI20V.DIA_Beziehungnen;

public class Test {
	//Variables
	private Bild bild = new Bild();
	private Auto auto = new Auto();
	private Gebaeude gebaeude = new Gebaeude();
	
	//Constructor
	public Test() {
		super();
		//Der Superkonstructor muss als erstes aufgerufen werden
		
		this.bild = bild;
		this.auto = auto;
		this.gebaeude = gebaeude;
	}
	
	
}
