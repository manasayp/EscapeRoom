package RoomX;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

//new
import javax.swing.text.AttributeSet;	
import javax.swing.text.BadLocationException;			
import javax.swing.text.PlainDocument;




public class P1 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JPanel displayPanel;
	private JPanel wallPanel;
	private JButton lock,clue,pause,stop,restart;
	ArrayList<JButton> items;
	ArrayList<JButton> otherJButtons;
	Integer rest;
	Timer timer1;
	JLabel timer2;
	Level lvl1;
	Clip clip,clip1;
	boolean isRunning;
	//new
	PanelController pc;
	JDialog cur_dialog;
    private String itemImg = "";

	
	public P1(int lvl, PanelController pc)
	{

		lvl1 = new Level(lvl);
		rest = lvl1.timer;
	    items = new ArrayList<JButton>();
	    otherJButtons = new ArrayList<JButton>();
	    //new
	    this.pc = pc;
        setBackground(Color.BLACK);

	    
		wallPanel = new imagePanel1(lvl1.imageDir);
		try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource("music/GBM.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         //clip.start();
	         clip.loop(Clip.LOOP_CONTINUOUSLY);

	         
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   
		
		//Create Top Panel
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.BLACK);
		controlPanel.setBorder(new LineBorder(Color.BLACK));
		controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.X_AXIS));
		controlPanel.setSize(new Dimension(100, 100));
		
		//Add Control icons
        ImageIcon pause_icon = getScaledIcon("images/pause.png",50,50);
		pause = new JButton(pause_icon);
		pause.setFont(new Font("Tahoma", Font.BOLD, 20));
		pause.setBackground(Color.DARK_GRAY);
		pause.setPreferredSize(new Dimension(75,75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		pause.setOpaque(false);
		pause.setContentAreaFilled(false);
		pause.setBorderPainted(false);
		pause.addActionListener(this);
		controlPanel.add(pause);
		otherJButtons.add(pause);

		
        ImageIcon stop_icon = getScaledIcon("images/stop.png",50,50);
		stop = new JButton(stop_icon);
		stop.setFont(new Font("Tahoma", Font.BOLD, 20));
		stop.setForeground(Color.WHITE);
		stop.setBackground(Color.DARK_GRAY);
		stop.setPreferredSize(new Dimension(75, 75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		stop.setOpaque(false);
		stop.setContentAreaFilled(false);
		stop.setBorderPainted(false);
		stop.addActionListener(this);
		controlPanel.add(stop);
		
		otherJButtons.add(stop);

		
        ImageIcon restart_icon = getScaledIcon("images/play.png",50,50);
		restart = new JButton(restart_icon);
		restart.setFont(new Font("Tahoma", Font.BOLD, 20));
		restart.setForeground(Color.WHITE);
		restart.setBackground(Color.DARK_GRAY);
		restart.setPreferredSize(new Dimension(75, 75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		restart.setOpaque(false);
		restart.setContentAreaFilled(false);
		restart.setBorderPainted(false);
		restart.addActionListener(this);
		controlPanel.add(restart);
		otherJButtons.add(restart);
		
        controlPanel.add(Box.createHorizontalGlue());

		timer2 = new JLabel();
		timer2.setFont(new Font("Tahoma", Font.BOLD, 28));
		timer2.setForeground(Color.white);
		timer2.setPreferredSize(new Dimension(150, 100));
		controlPanel.add(Box.createGlue());
		controlPanel.add(timer2);
		this.resume();

		//Create right panel
		displayPanel = new JPanel();
        displayPanel.setBackground(Color.BLACK);
		displayPanel.setForeground(new Color(0, 0, 0));
		displayPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
        displayPanel.setLayout(new BoxLayout(displayPanel,BoxLayout.Y_AXIS));
		//displayPanel.setLayout(new GridLayout(6,1,5,5));
        displayPanel.setPreferredSize(new Dimension(100, 600));
				
		
		for(EmptyClue a : lvl1.clues){
			if(a instanceof PictureClue || a instanceof WordClue )
			{
            itemImg = a.background;
			JButton item = new JButton("?");
			item.setBackground(new Color(153, 102, 51));
			item.setFont(new Font("Tahoma", Font.BOLD, 27));
			item.setMaximumSize(new Dimension(Integer.MAX_VALUE, item.getMinimumSize().height));
			item.setEnabled(false);
			//item1.setPreferredSize(new Dimension(120, 100));
			item.addActionListener(new ActionListener(){			
				public void actionPerformed(ActionEvent e){			

			    	JDialog dialog = new JDialog();
			    	cur_dialog = dialog;
			    	Container window = dialog.getContentPane();
			    	dialog.setSize(200, 250);	
			    	itemImg = a.background;
			    	//System.out.println(itemImg);
			    	JPanel dialogPanel = new imagePanel1(itemImg);
			    	dialogPanel.setBackground(new Color(255, 255, 204, 1));
			    	dialogPanel.setLayout(new BoxLayout(dialogPanel,BoxLayout.Y_AXIS));
			    	dialogPanel.setSize(new Dimension(300, 200));
			    	dialogPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

			    	JButton save = new JButton("OK");
			    	save.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			    	save.setForeground(new Color(51, 0, 0));
			    	save.setPreferredSize(new Dimension(50,30));
			    	save.setBackground(new Color(255, 255, 255));
			    	save.setFocusPainted(false);
			    	save.setAlignmentX(CENTER_ALIGNMENT);
			    	if(a instanceof WordClue)
			    	{
			    	JLabel puzzle = new JLabel();
			    	puzzle.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
			    	puzzle.setText(a.content);
			    	puzzle.setForeground(Color.WHITE);
			    	puzzle.setAlignmentX(CENTER_ALIGNMENT);
			    	dialogPanel.add(Box.createRigidArea(new Dimension(75,10)));
			    	dialogPanel.add(puzzle);
			    	}	    	
			    	dialogPanel.add(Box.createVerticalGlue());
			    	dialogPanel.add(save);
			    	dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));
			    	dialog.setUndecorated(true);
			    	window.add(dialogPanel);
			    	dialog.setVisible(true);
			    	dialog.setLocationRelativeTo(null);

					disablebuttons(null);
					dialog.setAlwaysOnTop(true);
					
					
					save.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent e) { 
							enablebuttons();
							dialog.dispose();
						 } 
					});
				}        			
			});
			items.add(item);
			displayPanel.add(item);
			}
			
			//Adding invisible buttons for hidden clues/puzzles
			JButton obj = new JButton("");
			otherJButtons.add(obj);
			obj.setVisible(true);
			obj.setOpaque(false);
			obj.setContentAreaFilled(false);
			obj.setBorderPainted(false);
			obj.setBounds(a.hpos,a.vpos,a.hsize,a.vsize);
			obj.addActionListener(new ActionListener()
			{
				
				
			    public void actionPerformed(ActionEvent e)
			    {
			    	 
			    	try {
				         // Open an audio input stream.
				         URL url = this.getClass().getClassLoader().getResource("music/Clue.wav");
				         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				         // Get a sound clip resource.
				         clip1 = AudioSystem.getClip();
				         // Open audio clip and load samples from the audio input stream.
				         clip1.open(audioIn);
				         clip1.start();
				      } catch (UnsupportedAudioFileException e1) {
				         e1.printStackTrace();
				      } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	a.found = true;
			    	JDialog dialog = new JDialog();
			    	cur_dialog = dialog;
			    	Container window = dialog.getContentPane();
			    	dialog.setSize(250, 300);	
//			    	if(a instanceof WordClue)
//			    		itemImg = getItemImagePath(lvl1.level,a.id);
//			    	else if(a instanceof PictureClue)
//			    		itemImg = "images/Pic"+a.id+".jpg";
//			    	else
//			    		itemImg = "images/sad1.jpg";
			    	itemImg = a.background;
			    	//System.out.println(itemImg);
			    	JPanel dialogPanel = new imagePanel1("images/wood.jpg");
			    	dialogPanel.setBackground(new Color(255, 255, 204, 1));
			    	dialogPanel.setLayout(new BoxLayout(dialogPanel,BoxLayout.Y_AXIS));
			    	dialogPanel.setSize(new Dimension(200, 200));
			    	dialogPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

			    	String text = "SAVE";
			    	if(a instanceof WordClue == false && a instanceof PictureClue == false)
			    		text = "OK"; 
			    	JButton save = new JButton(text);
			    	save.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			    	save.setForeground(new Color(51, 0, 0));
			    	save.setPreferredSize(new Dimension(50,30));
			    	save.setBackground(new Color(255, 255, 255));
			    	save.setFocusPainted(false);
			    	save.setAlignmentX(Component.CENTER_ALIGNMENT);
			    	
			    	JPanel picWindow = new imagePanel1(itemImg);
			    	picWindow.setSize(200, 100);
			    	if(a instanceof WordClue)
			    	{
			    	    JLabel puzzle = new JLabel();
			    	    puzzle.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
			    	    puzzle.setText(a.content);
			    	    puzzle.setForeground(Color.WHITE);
			    	    puzzle.setAlignmentX(CENTER_ALIGNMENT);
			    	    //dialogPanel.add(Box.createRigidArea(new Dimension(75,10)));
			    	    picWindow.add(puzzle);
			    	}
			    	dialogPanel.add(picWindow);
			    	//dialogPanel.add(Box.createVerticalGlue());
			    	dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));
			    	dialogPanel.add(save);
			    	dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));		    
			    	dialog.setUndecorated(true);
			    	window.add(dialogPanel);
			    	dialog.setVisible(true);
			    	dialog.setLocationRelativeTo(obj);
					disablebuttons(null);
					dialog.setAlwaysOnTop(true);
	    	
			    	save.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent e) { 
							
							enablebuttons();
							if(a instanceof WordClue || a instanceof PictureClue)
							{
							itemImg = a.background; 
                            
							if(!items.get(a.id-1).isEnabled()){
                                items.get(a.id-1).setIcon(getScaledIcon(itemImg,20,20));
								items.get(a.id-1).setEnabled(true);
								items.get(a.id-1).revalidate();
								items.get(a.id-1).setText(String.valueOf(a.id));
							    //items.get(0).setBackground(Color.CYAN);
							}
							}
							 dialog.dispose();
				        		clip1.stop();
						  } 
					} );
			    }
			});
			wallPanel.add(obj);
		}
		//yes
		displayPanel.add(Box.createVerticalGlue());
		ImageIcon clue_icon = getScaledIcon("images/bulb.png",75,75);
		clue = new JButton(clue_icon);
		clue.setFont(new Font("Verdana", Font.BOLD, 22));
		clue.setMaximumSize(new Dimension(Integer.MAX_VALUE, clue.getMinimumSize().height));
		//clue.setAlignmentY(Component.TOP_ALIGNMENT);
		//clue.setPreferredSize(new Dimension(120, 100));
		clue.setBackground(new Color(30, 144, 255));
	    clue.setForeground(new Color(255, 255, 255));
	    clue.setOpaque(false);
	    clue.setContentAreaFilled(false);
	    clue.setBorderPainted(false);	
	    clue.setFocusPainted(false);
	    clue.createToolTip();
	    clue.setToolTipText("Click for Hint");
		clue.addActionListener(this);
		displayPanel.add(clue);
        otherJButtons.add(clue);
		displayPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		ImageIcon lock_icon = getScaledIcon("images/Unlock.png",75,75);
		//displayPanel.add(Box.createVerticalGlue());
		lock = new JButton(lock_icon);
		lock.setFont(new Font("Verdana", Font.BOLD, 22));
		lock.setMaximumSize(new Dimension(Integer.MAX_VALUE, lock.getMinimumSize().height));
		//lock.setPreferredSize(new Dimension(120, 100));
		lock.setForeground(new Color(255, 255, 255));
		lock.setBackground(new Color(255, 102, 0));
		lock.setOpaque(false);
		lock.setContentAreaFilled(false);
		lock.setBorderPainted(false);	
		lock.addActionListener(this);
		lock.setFocusPainted(false);
		lock.createToolTip();
		lock.setToolTipText("Click to unlock");
		displayPanel.add(lock);	
		otherJButtons.add(lock);	
		wallPanel.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		add(wallPanel,BorderLayout.CENTER);
		add(controlPanel,BorderLayout.NORTH);
		add(displayPanel,BorderLayout.EAST);
		
		setSize(700,700);
		setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e) 
   {		
	    if(e.getSource().equals(pause))
	    {
	   	 	this.pause();
			//JOptionPane.showMessageDialog( null, "You pressed pause button" );
		}
		else if(e.getSource().equals(stop))
		{   
			this.pause();
			//JOptionPane.showMessageDialog( null, "Go back?" );
			clip.stop();
			JDialog dialog = new JDialog();
			cur_dialog = dialog;
			dialog.getContentPane().setBackground(new Color(255, 255, 204));
	    	dialog.setLocationRelativeTo(pause);
	    	Container window = dialog.getContentPane();
	        window.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
			
	        window.add(Box.createVerticalGlue());
			JPanel stopmsg = new JPanel();
			
			stopmsg.setBackground(new Color(255, 255, 204));
			JButton Continue = new JButton("Continue");
			//Continue.setForeground(new Color(255, 255, 255));
			Continue.setBackground(new Color(153, 0, 0));
			Continue.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			Continue.setVisible(true);
			Continue.setFocusPainted(false);
			Continue.setPreferredSize(new Dimension(120,50));
			stopmsg.add(Continue);
			
			Continue.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					dialog.removeAll();
					dialog.setVisible(false);
					resume();
					
				} 
			} );
			
			JButton Quit = new JButton("Quit");
			//Quit.setForeground(new Color(255, 255, 255));
			Quit.setBackground(new Color(153, 0, 0));
			Quit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			Quit.setVisible(true);
			Quit.setFocusPainted(false);
			Quit.setPreferredSize(new Dimension(100,50));
			
			JLabel label = new JLabel("");
			stopmsg.add(label);
			stopmsg.add(Quit);
			Quit.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					
					//container.setContentPane(P0);
					pc.switchPanel(0, 0);
					dialog.removeAll();
					dialog.setVisible(false);
					clip.stop();

				}
			} );
			window.add(stopmsg);
	        dialog.setUndecorated(true);	   
	    	dialog.setSize(400, 200);
	    	dialog.setVisible(true);
	    	dialog.setAlwaysOnTop(true);
			
		}
		else if(e.getSource().equals(restart))
		{
			this.resume();
			//JOptionPane.showMessageDialog( null, "You pressed restart button" );
		}
		else if(e.getSource().equals(clue))
	    {
			ArrayList<EmptyClue> clues = lvl1.clues;
			String hint = "You have found all clues!";
			for(EmptyClue a: clues){
				if(a.found == true) continue;
				else{
					if(a instanceof WordClue){
						hint = ((WordClue)a).hint;
					}
					if(a instanceof PictureClue){
						hint = ((PictureClue)a).hint;
					}
			    	break;
				}
			}
		    //UIManager.put("JOptionPane.background",Color.YELLOW);
			//JOptionPane.showMessageDialog( null, getMessagePanel(hint,"images/bulb.png"),"Hint",JOptionPane.PLAIN_MESSAGE);	
			//UIManager.put("JOptionPane.background",Color.WHITE);
			JDialog dialog = new JDialog();
            cur_dialog = dialog;
            Container window = dialog.getContentPane();
            dialog.setSize(220, 100);   
            JPanel dialogPanel = new imagePanel1("images/wood.jpg");
            ImageIcon bulb_icon = getScaledIcon("images/bulb.png",25,25);
    		dialogPanel.setBackground(new Color(255, 255, 204, 1));
            dialogPanel.setLayout(new BoxLayout(dialogPanel,BoxLayout.Y_AXIS));
            dialogPanel.setSize(new Dimension(220, 100));
            dialogPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
            dialog.setLocationRelativeTo(clue);
 
            JButton save = new JButton(bulb_icon);
            save.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            save.setForeground(new Color(51, 0, 0));
            save.setPreferredSize(new Dimension(25,25));
            save.setBackground(new Color(255, 255, 255));
            save.setFocusPainted(false);
            save.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel puzzle = new JLabel();
            puzzle.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            puzzle.setText(hint);
            puzzle.setForeground(Color.WHITE);
            dialogPanel.add(Box.createRigidArea(new Dimension(5,10)));
            dialogPanel.add(puzzle);
            dialogPanel.add(Box.createVerticalGlue());
            dialogPanel.add(save);
            dialogPanel.add(Box.createRigidArea(new Dimension(0,10)));
            dialog.setUndecorated(true);
            window.add(dialogPanel);
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
 
            disablebuttons(null);
            dialog.setAlwaysOnTop(true);
            
            
            save.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    enablebuttons();
                    dialog.dispose();
                 } 
            });         
            
	    }
		else if(e.getSource().equals(lock))
	    {
			JDialog dialog = new JDialog();
			cur_dialog = dialog;
            dialog.setAlwaysOnTop(true);
			Container container2 = dialog.getContentPane();
	    	container2.setLayout(new BorderLayout());
	    	dialog.setLocationRelativeTo(controlPanel);
	    	dialog.setUndecorated(true);
	    	dialog.setSize(400, 300);
			
	    	//Panel to enter lock code
	    	JPanel inputPanel = new JPanel();
	    	inputPanel.setBackground(new Color(255, 255, 204));
	    	inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.Y_AXIS));	
	    	inputPanel.setPreferredSize(new Dimension(400,100));
	    	JLabel n1 = new JLabel("Enter 4 Digit Lock Code");
	    	n1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    	inputPanel.add(Box.createRigidArea(new Dimension(0,20)));
	    	inputPanel.add(n1);
	    	inputPanel.add(Box.createRigidArea(new Dimension(0,20)));
			Box b = Box.createHorizontalBox();
			//FlowLayout f = new FlowLayout();
			
			b.add(Box.createRigidArea(new Dimension(20,0)));
			//JLabel n1 = new JLabel("4-Dgit Lock Code");
			JTextField tf1 = new JTextField("",1);
			tf1.setFont(new Font("Verdana", Font.PLAIN, 18));
			//b.add(n1);
			b.add(tf1);
			tf1.setDocument(new JTextFieldLimit(1));
			
			b.add(Box.createRigidArea(new Dimension(20,0)));
			JTextField tf2 = new JTextField(" ",1);
			tf2.setFont(new Font("Verdana", Font.PLAIN, 18));
			//b.add(n2);
			b.add(tf2);
			tf2.setDocument(new JTextFieldLimit(1));
			
			b.add(Box.createRigidArea(new Dimension(20,0)));
			JTextField tf3 = new JTextField("",1);
			tf3.setFont(new Font("Verdana", Font.PLAIN, 18));
			//b.add(n3);
			b.add(tf3);
			tf3.setDocument(new JTextFieldLimit(1));
			
			b.add(Box.createRigidArea(new Dimension(20,0)));
			JTextField tf4 = new JTextField(" ",1);
			tf4.setFont(new Font("Verdana", Font.PLAIN, 18));
			//b.add(n4);
			b.add(tf4);
			tf4.setDocument(new JTextFieldLimit(1));
			b.add(Box.createRigidArea(new Dimension(20,0)));
			inputPanel.add(b);
			
			//Panel to enter Output
			JPanel outputPanel = new JPanel();
			outputPanel.setLayout(new BoxLayout(outputPanel,BoxLayout.Y_AXIS));
			outputPanel.setBackground(new Color(255, 255, 204));
			outputPanel.setSize(400,50);
			JLabel textfield = new JLabel("Enter Lock Code");
			textfield.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			textfield.setVisible(false);
			textfield.setAlignmentX(Component.CENTER_ALIGNMENT);
			outputPanel.add(Box.createRigidArea(new Dimension(0,10)));
			outputPanel.add(textfield);
			outputPanel.add(Box.createRigidArea(new Dimension(0,10)));
			outputPanel.setVisible(false);
			
			//Panel for Buttons
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(new Color(255, 255, 204));
			buttonPanel.setBorder(null);
			buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
			buttonPanel.add(Box.createRigidArea(new Dimension(100,0)));
			JButton NewButton1 = new JButton("Try");
			NewButton1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			NewButton1.setBackground(new Color(204, 102, 0));
			NewButton1.setPreferredSize(new Dimension(100,50));
			buttonPanel.add(NewButton1);
			buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
			JButton NewButton2 = new JButton("Leave");
			NewButton2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			NewButton2.setBackground(new Color(204, 102, 0));
			buttonPanel.add(NewButton2);
			buttonPanel.add(Box.createRigidArea(new Dimension(0,20)));
			buttonPanel.setSize(400,150);
			
			NewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String temp_res = tf1.getText() + tf2.getText() + tf3.getText() + tf4.getText();
					if(temp_res.equals(lvl1.passcode)){
						enablebuttons();
						cur_dialog.removeAll();
						cur_dialog.setVisible(false);
		        		timer1.cancel();
		        	    removeAll();	
		        	    setVisible(false);
		        		//removehere();
		    			pc.switchPanel(2, 0);
						clip.stop();

					}else{
						if(!temp_res.isEmpty())
						{
							outputPanel.setVisible(true);
							textfield.setVisible(true);
							textfield.setText("Wrong answer..Try again!");
						}
						else{
							outputPanel.setVisible(true);
							textfield.setVisible(true);
							textfield.setText("Please enter 4 digit lock code!");
						}
						//JOptionPane.showMessageDialog( null, "Wrong answer!");
					}
				}
			});
			NewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					enablebuttons();
					dialog.dispose();
				}
			});
			
	        container2.add(inputPanel,
	                BorderLayout.NORTH);
	        container2.add(outputPanel,
	                BorderLayout.SOUTH);
	        container2.add(buttonPanel,
	                BorderLayout.CENTER);
	        //dialog.add(container2);
	    	//pack();
	        dialog.setVisible(true);
	        dialog.setAlwaysOnTop(true);
	        disablebuttons(null);
		}
	    
   }
   
	void pause(){
    	timer1.cancel();
    	isRunning = false;
    	disablebuttons(restart);
    	clip.stop();
    }
	
    void resume(){
    	if(isRunning == true) return;
        timer1 = new Timer();
        timer1.schedule(new RemindTask1(), 0, 1000);
        isRunning = true;
        enablebuttons();
        
        clip.setFramePosition(0);
        clip.start();
    }
    
    class RemindTask1 extends TimerTask {
    	
        public void run() {
        	rest--;
        	timer2.setText(rest.toString());
        	if(rest <= 0){
        		timer1.cancel();
        		if (clip1 != null && clip1.isRunning()) clip1.stop();
        		
        		clip.stop();
        		
        		if(cur_dialog != null){
                    cur_dialog.removeAll();
                    cur_dialog.setVisible(false);
                }
    			pc.switchPanel(3, 0);
        		//System.out.println("Timer is done!");
        	}
            //timer1.cancel(); //Terminate the timer thread
        }
    }
    
    void disablebuttons(JButton st){
    	for(JButton a: otherJButtons){
    		if(a == st) continue;
    		a.setEnabled(false);
    		a.setDisabledIcon(a.getIcon());
    		//a.removeActionListener(a.);
    	}
    	for(JButton a: items){
    		a.setEnabled(false);
    		a.setDisabledIcon(a.getIcon());
    	}
    }
    
    void enablebuttons(){
    	for(JButton a: otherJButtons){
    			a.setEnabled(true);
    	}
    	for(JButton a: items){
    			if(a.getText() != "?") a.setEnabled(true);
    	}    	
    }
    
    private ImageIcon getScaledIcon(String imagePath,int width,int height)
    {
 	    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imagePath));  
 		Image imgIcon = icon.getImage();
 		Image newImgIcon = imgIcon.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
 		icon = new ImageIcon(newImgIcon);
 		return icon;
    }
}



class JTextFieldLimit extends PlainDocument {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}
