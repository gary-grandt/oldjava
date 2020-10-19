package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import STD.RandomS;

public class Zeichnen {
	//Variables
	private int width = 640;
	private int height = 480;
	
	private final int a = 255;
	private int r;
	private int g;
	private int b;
	private int pixel;
	
	private String path ="C:\\Users\\Gary Grandt\\Desktop\\Output.png";
	
	//Objects
	private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	private RandomS random = new RandomS();
	private File f = new File(path);
	
	//Main
	private void main() {
		//Random Pixel Printing
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				//Random RGBs
				r = random.randInt(0,255);
				g = random.randInt(0, 255);
				b = random.randInt(0, 255);
				//Pixel creation
				pixel = (a<<24) | (r<<16) | (g<<8) | b;
				//Print to Image
				img.setRGB(x, y, pixel);
			}
		} 		//Print Image
		try {
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Start
	public static void main(String arges[]) {
		Zeichnen run = new Zeichnen();
		run.main();
	}
}
