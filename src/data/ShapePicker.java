package data;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.ColorPicker.Choices;
import main.Frame;

public class ShapePicker {
	public static ColorPicker choice = new ColorPicker();
	
	public enum Shape {
		line,
		circle,
		square,
		rectangle;
	}
	
	static Shape shape = Shape.line;
	
	public static Shape getShape() {
		return shape;
	}
	
	public static void setShape(Shape shapeChoice) {
		ShapePicker.shape = shapeChoice;
	}
	
	public static void drawLine(int sX, int sY, int eX, int eY) {
		Graphics2D g = ((BufferedImage) Frame.drawing).createGraphics();
		g.setColor(setColor());
		g.drawLine(sX, sY, eX, eY);
		g.dispose();
	}

	public static void drawCircle(int x, int y, int w, int h) {
		Graphics2D g = ((BufferedImage) Frame.drawing).createGraphics();
		g.setColor(setColor());
		g.drawOval(x, y, w, h);
		g.dispose();
	}
	
	public static void drawSquare(int x, int y) {
		Graphics2D g = ((BufferedImage) Frame.drawing).createGraphics();
		g.setColor(setColor());
		g.drawRect(x, y, 100, 100);
		g.dispose();
	}
	
	public static void drawRectangle(int x, int y, int w, int h) {
		Graphics2D g = ((BufferedImage) Frame.drawing).createGraphics();
		g.setColor(setColor());
		g.drawRect(x, y, w, h);
		g.dispose();
	}
	
	public static void clear() {
		Graphics2D g = ((BufferedImage) Frame.drawing).createGraphics();
		g.clearRect(0, 0, 100, 100);
		g.dispose();
	}
	
	public static Color setColor() {
		if(ColorPicker.getColor() == Choices.Black) {
			return Color.BLACK;
		} else if(ColorPicker.getColor() == Choices.White) {
			return Color.WHITE;
		} else if (ColorPicker.getColor() == Choices.Red) {
			return Color.RED;
		} else if (ColorPicker.getColor() == Choices.Green) {
			return Color.GREEN;
		} else if (ColorPicker.getColor() == Choices.Blue) {
			return Color.BLUE;
		}
		return null;
	}
}