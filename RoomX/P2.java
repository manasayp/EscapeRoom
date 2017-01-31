package RoomX;
import java.awt.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class P2 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelController pc;
	Clip clip2;
	private Image backgroundImage;

	public P2(PanelController pc) {
		
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/Open1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource("music/win.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         clip2 = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip2.open(audioIn);
	         clip2.start();
	      } catch (UnsupportedAudioFileException e1) {
	         e1.printStackTrace();
	      } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		this.pc = pc;
		
		JButton btnNewButton = new JButton("End");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255,222,173));
		
		//btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnNewButton.setBounds(120, 157, 89, 30);
		add(btnNewButton);
		
		JLabel lblCongratulationsYouEscaped = new JLabel("Congratulations! You escaped!");
		lblCongratulationsYouEscaped.setForeground(new Color(0, 255, 0));
		lblCongratulationsYouEscaped.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCongratulationsYouEscaped.setBackground(new Color(255,222,173));
		lblCongratulationsYouEscaped.setBounds(110, 82, 230, 30);
		add(lblCongratulationsYouEscaped);
		
		JButton btnRestart = new JButton("Play Again");
		btnRestart.setBackground(SystemColor.controlHighlight);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//                container.setContentPane(P0);	
				pc.switchPanel(0, 0);
                removeAll();			
                setVisible(false);
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRestart.setBounds(230, 157, 89, 30);
		add(btnRestart);

		setLayout(new BorderLayout());

		setSize(1000,666);
		setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0,this.getWidth(),this.getHeight(), this);
	}
	
    
}
