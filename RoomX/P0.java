package RoomX;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class P0 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1, exit;
	JRadioButton Level1, Level2;
	int lvl;
	PanelController pc;
	//m
	JButton inst;
	private Image backgroundImage;
	
	public P0(PanelController pc) {

		setLayout(null);
		setVisible(true);
		//setBackground(Color.orange);
		this.pc = pc;

		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/Img1.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		//JRadioButton
		Level1 = new JRadioButton("Level-1");
		Level1.setBounds(550,370,120,35);
		Level1.setVisible(true);	
		Level1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		Level1.setBackground(new Color(255,222,173));
        Level1.setOpaque(true);
        Level1.setBorderPainted(false);
				
		Level2 = new JRadioButton("Level-2");
		Level2.setBounds(550,470,120,35);
		Level2.setVisible(true);	
		Level2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		Level2.setBackground(new Color(255,222,173));
        Level2.setOpaque(true);
        Level2.setBorderPainted(false);
	
		ButtonGroup Group = new ButtonGroup();
		Group.add(Level1);
		Group.add(Level2);
			
		add(Level1);
		add(Level2);
	
		b1 = new JButton("Start");
		b1.setBounds(420,550,120,35);
		b1.setVisible(true);
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		b1.setBackground(new Color(255,222,173));
		add(b1);
	
		inst = new JButton("Instructions");
		inst.setBounds(800,50,150,35);
		inst.setVisible(true);
		inst.setOpaque(true);
		inst.setBorderPainted(false);
		inst.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		inst.setBackground(new Color(255,222,173));
		add(inst);
		
		//bug2
        exit = new JButton("Exit");	
        exit.setBounds(680,550,120,35);			
        exit.setVisible(true);	
		exit.setOpaque(true);
		//b1.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		exit.setBackground(new Color(255,222,173));
			
        //exit.setFocusable(false);
        add(exit);
	
		b1.addActionListener(this);
		//bug2
		exit.addActionListener(this);
		Level1.addActionListener(this);
		Level2.addActionListener(this);
		inst.addActionListener(this);

		setVisible(true);
	}
	
	
//	ActionListener actionListener = new ActionListener() {
//	    @Override
//	    public void actionPerformed(ActionEvent e) {
//	        boolean enable = check1.isSelected() && check3.isSelected();
//	        buttonToBeEnabled.setEnabled(enable);
//	    }
//	};
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			//new
			if(lvl == 0){
				JOptionPane.showMessageDialog( null, "Please select the level" );
				return;
			};
			pc.switchPanel(1, lvl);
		}
		if (e.getSource() == exit) {			
			System.exit(0);			
		}
		if (e.getSource() == Level1) {
			//new
			lvl = 1;	
		}
		if (e.getSource() == Level2) {
			//new
			lvl = 2;	
		}
		if (e.getSource() == inst) {			
			
			final JDialog dialog = new JDialog();
			dialog.getContentPane().setBackground(new Color(255, 255, 204));
			dialog.setBounds(370, 0, 500, 630);
	    	Container window = dialog.getContentPane();
	        window.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
			dialog.setLocationRelativeTo(this);
			
	        //window.add(Box.createVerticalGlue());
			window.add(Box.createRigidArea(new Dimension(0,10)));
			JPanel instmsg = new JPanel();
			//instmsg.setLayout(new BoxLayout(instmsg,BoxLayout.Y_AXIS));
			//window.setLocation(null);
				
			
			JTextArea instructions = new JTextArea(4,44);
			JTextArea instructions1 = new JTextArea(9,44);
			JTextArea instructions2 = new JTextArea(3,44);
			JTextArea instructions3 = new JTextArea(3,44);
			JTextArea instructions4 = new JTextArea(1,44);
			JTextArea instructions5 = new JTextArea(4,44);
			JTextArea instructions6 = new JTextArea(4,44);
			
			instructions.setEditable(false);
			instructions1.setEditable(false);
			instructions2.setEditable(false);
			instructions3.setEditable(false);
			instructions4.setEditable(false);
			instructions5.setEditable(false);
			instructions6.setEditable(false);

			//instructions.setHorizontalAlignment(JTextField.LEFT);
			//instructions.setVerticalAlignment(JTextField.TOP);
			instructions.setText("1. Room-escape is an adventure game. "
					+ "Please first click on the radio button to pick your desired level. "
					+ "Level 2 will take less time with more difficulty than level 1. "
					+ "You can't click on the start button to proceed without selecting the level. "
					+ "Otherwise a dialog message will pop up.  ");
			instructions1.setText("2. After starting the game, you can click on the three top-left icons to pause, stop and resume the game. "
					+ "If you wish a break, you can click pause icon to stop the timer on the right top. "
					+ "During this period, none of the square transparent icons inside the game panel are accessible. "
					+ "Click resume icon to continue your process, and the timer will be counting down again. "
					+ "Or if you find it hard to try on, you can click stop icon and a pop-up window will come out. "
					+ "Choose Quit to go back to the main interface. "
					+ "Similarly, you will be forbidden to use any mouse click on the square icons. "
					+ "Choose Continue if you still wish to stay in the current level. ");
			instructions2.setText("3. When the timer is couting down, you can click on those square icons to find clues. "
					+ "Then an enlarged image of either a picture or a word clue will be displayed. "
					+ "You need to quickly tell the hidden information from that image to get a correct number in your mind. ");
			instructions3.setText("4. Click Save to store the useful clues and click OK if you find a null clue. "
					+ "Mini icons of useful clues will be in the display panel on the right side "
					+ "but null clues will be left as a question mark icon in the list. ");
			instructions4.setText("5. Also feel free to hit the bulb icon on the right hand when you get stuck on one clue. "
					+ "Hint infomation inside the bulb will help you make progress. ");
			instructions5.setText("6. After you get all clues, click the lock icon and then input four numbers from those saved clues. "
					+ "Type in 1 digit in each text box to generate your passcodes. "
					+ "Click Try to see if you can unlock successfully. If so, you will be directed to the winning panel. "
					+ "If not, you may choose Leave to return back to game panel. ");
			instructions6.setText("7. Remeber you will fail in trying passcodes when time is up, and it'll direct you to the losing panel. "
					+ "So, don't forget to check your remaining time, the timer is couting down! "
					+ "Wish you good luck and enjoy the game!");
			instructions.setPreferredSize(new Dimension(18,52));
			instructions.setLineWrap(true);
			instructions.setWrapStyleWord(true);
			instructions1.setLineWrap(true);
			instructions1.setWrapStyleWord(true);
			instructions2.setLineWrap(true);
			instructions2.setWrapStyleWord(true);
			instructions3.setLineWrap(true);
			instructions3.setWrapStyleWord(true);
			instructions4.setLineWrap(true);
			instructions4.setWrapStyleWord(true);
			instructions5.setLineWrap(true);
			instructions5.setWrapStyleWord(true);
			instructions6.setLineWrap(true);
			instructions6.setWrapStyleWord(true);
			
			instructions.setBounds(300,2,120,40);
			instructions.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions.setOpaque(false);
			instructions1.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions1.setOpaque(false);
			instructions2.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions2.setOpaque(false);
			instructions3.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions3.setOpaque(false);
			instructions4.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions4.setOpaque(false);
			instructions5.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions5.setOpaque(false);
			instructions6.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
			instructions6.setOpaque(false);
			instructions.setSize(200,200);
			instmsg.add(instructions);
			instmsg.add(instructions1);
			instmsg.add(instructions2);
			instmsg.add(instructions3);
			instmsg.add(instructions4);
			instmsg.add(instructions5);
			instmsg.add(instructions6);
					//instmsg.add(Box.createVerticalGlue());
			
			instmsg.setBackground(new Color(255, 255, 204));
			JButton Continue = new JButton("Continue");
			//Continue.setForeground(new Color(255, 255, 255));
			Continue.setBackground(new Color(153, 0, 0));
			Continue.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			Continue.setVisible(true);
			Continue.setFocusPainted(false);
			//Continue.setPreferredSize(new Dimension(120,50));
			Continue.setBounds(0,700,120,50);	
			instmsg.add(Continue);
			
			Continue.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					dialog.removeAll();
					dialog.setVisible(false);
								
				} 
			} );
			window.add(instmsg);
	        dialog.setUndecorated(true);	   
	    	//dialog.setSize(500, 666);
	    	
	    	dialog.setVisible(true);

		}
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    // Draw the background image.
		    g.drawImage(backgroundImage, 0, 0,this.getWidth(),this.getHeight(), this);
	}
    
}
