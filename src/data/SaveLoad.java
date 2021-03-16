package data;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.Frame;

public class SaveLoad {
	static JFileChooser chooser = new JFileChooser();
	
	public static void saveImage() {  
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showSaveDialog(Frame.Window);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       File savedImage = new File(chooser.getSelectedFile()+".png");
	       System.out.println("Saving to: " + savedImage);
	       try {
				ImageIO.write((RenderedImage) Frame.drawing, "png", savedImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public static void loadImage() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(Frame.Window);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    System.out.println("Opening From: " + chooser.getSelectedFile());
		    try {
	    		Frame.drawing = ImageIO.read(new File(chooser.getSelectedFile().toURI()));
		    } catch (IOException e) {
		    	JOptionPane.showMessageDialog(chooser, "Invalid File, Please Try Again!");
		    	System.out.println("Invalid File, Please Try Again!");
		    	loadImage();
			}
	    }
	}
}