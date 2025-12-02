package com.alex.graphics.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Create the icons that go on the tools menu
 * 
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class CreateButtonImages {

	public static void main(String[] args) throws IOException {
		String folder = "/Users/alexv/workspace/stl-viewer/src/main/resources/buttons";

		int width = 40;
		int height = 40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		int margin = 5;
		g2.drawLine( margin, margin, width - margin, height - margin);
		File outputfile = new File(folder + "/line.png");
		ImageIO.write(image, "png", outputfile);

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		g2.drawOval( margin, margin, width - (2 * margin), height - (2 * margin));
		outputfile = new File(folder + "/circle.png");
		ImageIO.write(image, "png", outputfile);

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		g2.drawOval( margin, margin * 2, width - (2 * margin), height - (margin * 4) );
		outputfile = new File(folder + "/oval.png");
		ImageIO.write(image, "png", outputfile);

		//square
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		g2.drawRect( margin, margin, width - (2 * margin), height - (2 * margin) );
		outputfile = new File(folder + "/square.png");
		ImageIO.write(image, "png", outputfile);

		//rectangle
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		g2.drawRect( margin, margin * 2, width - (2 * margin) , height - (margin * 4) );
		outputfile = new File(folder + "/rectangle.png");
		ImageIO.write(image, "png", outputfile);

		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = image.createGraphics();
		g2.setColor(Color.BLUE);
		drawArrow( margin, margin, width - margin, height - margin, 20, g2);
		g2.setStroke(new BasicStroke(6.0f));
		g2.drawLine( margin + 10, margin + 10, width - margin, height - margin);
		outputfile = new File(folder + "/select.png");
		ImageIO.write(image, "png", outputfile);



	}

	/**
	 * @param tipX
	 * @param tipY
	 * @param tailX
	 * @param tailY
	 * @param arrowLength = about 7 for a line-end
	 * @param g
	 */
	private static void drawArrow(int tipX,  int tipY, int tailX, int tailY, int arrowLength,  Graphics2D g) {
		int dx = tipX - tailX;
		int dy = tipY - tailY;

		double theta = Math.atan2(dy, dx);

		double rad = Math.toRadians(35); //35 angle, can be adjusted
		double x = tipX - arrowLength * Math.cos(theta + rad);
		double y = tipY - arrowLength * Math.sin(theta + rad);

		double phi2 = Math.toRadians(-35);//-35 angle, can be adjusted
		double x2 = tipX - arrowLength * Math.cos(theta + phi2);
		double y2 = tipY - arrowLength * Math.sin(theta + phi2);

		int[] arrowYs = new int[3];
		arrowYs[0] = tipY;
		arrowYs[1] = (int) y;
		arrowYs[2] = (int) y2;

		int[] arrowXs = new int[3];
		arrowXs[0] = tipX;
		arrowXs[1] = (int) x;
		arrowXs[2] = (int) x2;

		g.fillPolygon(arrowXs, arrowYs, 3);


	}

}
