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

public class P3 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image backgroundImage;

	PanelController pc;
	Clip clip3;
	
	public P3(PanelController pc) {
		
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/Pooh_naps.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource("music/lost.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         clip3 = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip3.open(audioIn);
	         clip3.start();
	      } catch (UnsupportedAudioFileException e1) {
	         e1.printStackTrace();
	      } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBackground(SystemColor.menuText);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		this.pc = pc;
	
		JLabel lblSorryYouLost = new JLabel("Out of time! You failed!");
		lblSorryYouLost.setForeground(Color.RED);
		lblSorryYouLost.setBounds(130, 70, 200, 30);
		lblSorryYouLost.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSorryYouLost.setBackground(new Color(255,222,173));
		add(lblSorryYouLost);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnNewButton.setBounds(125, 157, 89, 30);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255,222,173));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restart");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//               container.setContentPane(P0);	
				pc.switchPanel(0, 0);
	            removeAll();			
	            setVisible(false);
			}
		});
		btnNewButton_1.setBounds(230, 157, 89, 30);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(255,222,173));
		add(btnNewButton_1);

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
