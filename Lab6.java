//COSC1047 Lab#6 - Adam Byrne 


package javaapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Lab6 extends JFrame {

    public Lab6() {
    	add(new NewPanel());
    }
      
		public static void main(String[] args) {
			Lab6 frame = new Lab6();
			frame.setTitle("Lab6");
			frame.setSize(600, 600);
			frame.setLocationRelativeTo(null); // Center the frame   
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	
	}


class NewPanel extends JPanel {
	private ImageIcon imageIcon = new ImageIcon("image.png");
	private Image image = imageIcon.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		//String
		g.drawString("Deformed Kiwi admires beautiful Robin", 180, 125);
		
		//Image
		if (image != null) {
			g.drawImage(image, 300, 200, 350, 350, this);
		}
		
		//Arc
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);
		g.fillArc(20, 150,radius, 2 * radius, 190, 10);
		
		//Polygon
		Polygon poly = new Polygon();
		poly.addPoint(180,250);
		poly.addPoint(200,240);
		poly.addPoint(280,280);
		g.drawPolygon(poly);
		
		//Polyline
		int[] x = {30, 40, 50, 60};
		int[] y = {40, 30, 60, 50};
		g.drawPolyline(x, y, x.length);

		
		//Rectangle
		g.fillRect(135, 500, 20, 20);
		g.fillRect(200, 500, 20, 20);
		
		//Oval
		g.fillOval(90, 250, 100, 180);
		g.fillOval(140, 220, 60,  60);
		
		//Lines
		g.drawLine(200, 500, 100, 300);
		g.drawLine(140, 500, 100, 300);
		
		
	}
}

	