package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.ColorPicker;
import data.ShapePicker;
import data.ColorPicker.Choices;
import data.SaveLoad;
import data.ShapePicker.Shape;

public class Frame extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Painting Place";
	
	static JButton Clear = new JButton("Clear");
	static JButton Black = new JButton("Black");
	static JButton White = new JButton("White");
	static JButton Red = new JButton("Red");
	static JButton Green = new JButton("Green");
	static JButton Blue = new JButton("Blue");
	static JButton Line = new JButton("Line");
	static JButton Circle = new JButton("Circle");
	static JButton Square = new JButton("Square");
	static JButton Rectangle = new JButton("Rectangle");
	static JButton Save = new JButton("Save");
	static JButton Load = new JButton("Load");
	 
	private static final int W = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int H = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final Component draw = null;
	public static Image drawing = new BufferedImage(2000, 1000, BufferedImage.TYPE_INT_ARGB);
	public static Component Window;

	public Frame() {
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseListener() {
			int sX;
			int sY;
			int eX;
			int eY;
			@Override
			public void mousePressed(MouseEvent e) {
				sX = e.getX();
				sY = e.getY();
				if (ShapePicker.getShape() == Shape.square) {
					ShapePicker.drawSquare(e.getX(), e.getY());
				} else return;
				repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				eX = e.getX();
				eY = e.getY();
				int px = Math.min(sX, eX);
				int py = Math.min(sY, eY);
				int w = Math.abs(sX-eX);
				int h = Math.abs(sY-eY);
				if (ShapePicker.getShape() == Shape.line) {
					ShapePicker.drawLine(sX, sY, eX, eY);
				} else if (ShapePicker.getShape() == Shape.rectangle) {
					ShapePicker.drawRectangle(px, py, w, h);
				} else if(ShapePicker.getShape() == Shape.circle) {
					ShapePicker.drawCircle(px, py, w, h);
				} else return;
				repaint();
			}	

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});
	}
	
	public static void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame Window = new JFrame(TITLE);
                JPanel draw = new JPanel(); 
        		
        		Clear.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				drawing.getGraphics().clearRect(0, 0, 600, 480);
        				Graphics g = drawing.getGraphics();
        				g.fillRect(0, 0, 2000, 1000);
        				g.dispose();
        				draw.updateUI();
        			}
        		});
        		
        		Black.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ColorPicker.setChoice(Choices.Black);
        				System.out.println("Color set to black");
        			}
        		});
        		
        		White.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ColorPicker.setChoice(Choices.White);
        				System.out.println("Color set to white");
        			}
        		});
        		
        		Red.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ColorPicker.setChoice(Choices.Red);
        				System.out.println("Color set to red");
        			}
        		});
        		
        		Green.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ColorPicker.setChoice(Choices.Green);
        				System.out.println("Color set to green");
        			}
        		});
        		
        		Blue.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ColorPicker.setChoice(Choices.Blue);
        				System.out.println("Color set to blue");
        			}
        		});
        		
        		Save.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SaveLoad.saveImage();
						System.out.println("Image saved!");
					}
        		});
        		
        		Load.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SaveLoad.loadImage();
						draw.updateUI();
						System.out.println("Image Loaded!");
					}
        		});
        		
        		Line.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ShapePicker.setShape(Shape.line);
        				System.out.println("Shape set to line");
        			}
        		});
        		
        		Circle.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ShapePicker.setShape(Shape.circle);
        				System.out.println("Shape set to circle");
        			}
        		});
        		
        		Square.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ShapePicker.setShape(Shape.square);
        				System.out.println("Shape set to rectanlge");
        			}
        		});
        		
        		Rectangle.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ShapePicker.setShape(Shape.rectangle);
        				System.out.println("Shape set to custom rectanlge");
        			}
        		});
        		
        		JPanel top = new JPanel(new BorderLayout());
        		Box hor = Box.createHorizontalBox();
        		hor.add(Box.createHorizontalStrut(100));
        		hor.add(Save);
        		hor.add(Box.createHorizontalStrut(10));
        		hor.add(Load);
        		hor.add(Box.createHorizontalStrut(10));
        		hor.add(Clear);
        		hor.add(Box.createHorizontalStrut(250));
        		hor.add(Black);
        		hor.add(Box.createHorizontalStrut(100));
        		hor.add(White);
        		hor.add(Box.createHorizontalStrut(100));
        		hor.add(Red);
        		hor.add(Box.createHorizontalStrut(100));
        		hor.add(Green);
        		hor.add(Box.createHorizontalStrut(100));
        		hor.add(Blue);
        		top.add(hor);
                
                JPanel side = new JPanel(new BorderLayout());
                Box vert = Box.createVerticalBox();
                vert.add(Box.createVerticalStrut(300));
                vert.add(Line);
                vert.add(Box.createVerticalStrut(100));
                vert.add(Circle);
                vert.add(Box.createVerticalStrut(100));
                vert.add(Square);
                vert.add(Box.createVerticalStrut(100));
                vert.add(Rectangle);
                side.add(vert);
                
                draw.add(new Frame());
                draw.setVisible(true);
                
                Window.add(BorderLayout.NORTH, top);
                Window.add(BorderLayout.WEST, side);
                Window.add(BorderLayout.CENTER, draw);
                Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Window.pack();
                Window.setLocation(W/2-Window.getSize().width/2, H/2-Window.getSize().height/2);
                Window.setVisible(true);
            }
        });
    }

	@Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(drawing, 0, 0, this);
    }
}