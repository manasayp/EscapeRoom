package RoomX;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class imagePanel1 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
    public imagePanel1(String imagePath) {
    	//Read background Image
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0,this.getWidth(),this.getHeight(), this);
	  }
}

