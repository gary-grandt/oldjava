package UEbungen.GOI20V.DIA_Beziehungnen;

import java.awt.Color;

public class Kreis {
	//Variables
	private Color farbe;
	private double radius;
	private int dicke;
	static int anzahlKreise;
	
	//Geter
	public Color getFarbe() {
		return farbe;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public int getDicke() {
		return dicke;
	}
	
	//Seter
	public void setFarbe(Color input) {
		farbe = input;
	}
	
	public void setRadius(double input) {
		radius = input;
	}
	
	public void setDicke(int input) {
		dicke = input;
	}
	
	//Methodes
	public double giveUmfang() {
		return 2*radius*Math.PI;
	}
	
	public double giveFlaeche() {
		return (radius*radius)*Math.PI;
	}
	
}
