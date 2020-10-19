package Test;

import STD.Input;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class KubischeWendepunktVerteilung {
	/*
	 * Variables
	 */
	// For Math
	private int range;
	private float sliderSteprate;

	private int hochPunktX;
	private int hochPunktY;
	private int tiefPunktX;
	private int tiefPunktY;

	// For Printing
	private int pixelMultiplicator;
	// The size of the final Image
	private int img_size;
	// The size of the coodinateSystem
	private int displaySize;

	private final int alpha = 255;
	private int red = 0;
	private int green = 0;
	private int blue = 0;

	private int pixel;

	private final String path = "C:\\Users\\Gary Grandt\\Desktop\\KubischeWendepunktVerteilung.png";

	// For Program
	private boolean noMistakes;

	/*
	 * Objects
	 */
	Input input = new Input();
	// For Printing
	File file = new File(path);
	BufferedImage img;

	// Main
	public void main() {
		/*
		 * SetUp
		 */
		System.out.println("\n Kubische Wednepunkt Verteilung \n");

		// DisplaySize
		System.out.println("Wie groﬂ soll die Anzeige sein? (10 - 10000)");
		displaySize = input.inInt_com(10, 10000);

		// Pixel Multiplication
		System.out.println("Bitte geben sie denn Grad der Pixel-Multiplikation an: ");
		noMistakes = false;
		while (!noMistakes) {
			System.out.println("(1, 2, 4, 8)");

			pixelMultiplicator = input.inInt_com(1, 8);
			if (pixelMultiplicator == 1 || pixelMultiplicator == 2 || pixelMultiplicator == 4
					|| pixelMultiplicator == 8) {
				noMistakes = true;
			}
		}

		// Image size
		img_size = (displaySize * 2 * pixelMultiplicator) + (1 * pixelMultiplicator);

		// Image Buffer creation
		img = new BufferedImage(img_size, img_size, BufferedImage.TYPE_4BYTE_ABGR);

		// FillUp Black
		pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
		for (int x = 0; x < img_size; x++) {
			for (int y = 0; y < img_size; y++) {
				img.setRGB(x, y, pixel);
			}
		}

		// pixel -> with
		red = 255;
		green = 255;
		blue = 255;
		pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;

		/*
		 * Berrechnung
		 */

		System.out.println("Wie groﬂ soll die SliderRange sein?");
		System.out.println("(0, 1000)");
		range = input.inInt_com(0, 10000);

		for (float a3 = -range; a3 <= range; a3++) {
			for (float a1 = -range; a1 <= range; a1++) {
				hochPunktX = punktHochX(a3, a1);
				hochPunktY = punktHochY(a3, a1);

				tiefPunktX = punktTiefX(a3, a1);
				tiefPunktY = punktTiefY(a3, a1);
				
				System.out.println(" a3 : " + a3 + " a1 : " + a1);
				if (isPunktInRange(hochPunktX, hochPunktY) && isPunktInRange(tiefPunktX, tiefPunktY)) {
					printPoint(hochPunktX, hochPunktY);
					printPoint(tiefPunktX, tiefPunktY);
				}
			}
		}
		
		for (int x = -displaySize; x <= displaySize; x += 2) {
			printPoint(x, 0);
		}

		for (int y = -displaySize; y <= displaySize; y += 2) {
			printPoint(0, y);
		}
		
		// Print Image
		try {
			ImageIO.write(img, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Methods
	 */
	// Rechnen
	private int punktHochX(float a3, float a1) {
		return (int) ((Math.sqrt(-3 * a1 * a3)) / (3 * a3));
	}

	private int punktHochY(float a3, float a1) {
		return (int) (-(Math.sqrt(-3 * a1 * a3)) / (3 * a3));
	}

	private int punktTiefX(float a3, float a1) {
		return (int) ((2 * a1 * Math.sqrt(-3 * a1 * a3)) / (9 * a3));
	}

	private int punktTiefY(float a3, float a1) {
		return (int) (-(2 * a1 * Math.sqrt(-3 * a1 * a3)) / (9 * a3));
	}

	// IsInRange
	private boolean isPunktInRange(int x, int y) {
		if (x <= displaySize && x >= -displaySize && y <= displaySize && y >= -displaySize) {
			return true;
		} else {
			System.out.println("    Error: Can not Display");
			return false;
		}
	}

	// Print Point as Pixels
	private void printPoint(int xm, int ym) {
		int xp;
		int yp;
		// Inverting
		xm = xm * -1;
		ym = ym * -1;

		// xm -> xp
		xp = xm + displaySize;
		xp = xp * pixelMultiplicator;

		// ym -> yp
		yp = ym + displaySize;
		yp = yp * pixelMultiplicator;
		
		// Pint Pixel with Multiplication
		for (int x = 0; x < pixelMultiplicator; x++) {
			for (int y = 0; y < pixelMultiplicator; y++) {
				printPixel(xp + x, yp + y);
			}
		}
	}
	

	private void printPixel(int xp, int yp) {
		img.setRGB(xp, yp, pixel);
	}

	// Start
	public static void main(String arges[]) {
		KubischeWendepunktVerteilung run = new KubischeWendepunktVerteilung();
		run.main();
	}
}