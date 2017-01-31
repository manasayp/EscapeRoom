package RoomX;
import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	P0 p0;
	P1 p1;
	P2 p2;
	P3 p3;
	JPanel cur;
	PanelController pc;
	public Frame(PanelController pc) {
		super("New");
		setSize(1000,666);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pc = pc;
		
	}
	
	
	public void switchTo(int next, int acc){
		switch(next){
		case 0:
			if(p0 == null) p0 = new P0(pc);
			this.setContentPane(p0);
			this.setVisible(true);
			cur = p0;
			break;
		case 1: 
			p1 = new P1(acc, pc);
			this.setContentPane(p1);
			//frame.setVisible(true);
			cur = p1;
			break;
		case 2: 
			if(p2 == null) p2 = new P2(pc);
			this.setContentPane(p2);
			//frame.setVisible(true);
			cur = p2;
			break;
		case 3: 
			if(p3 == null) p3 = new P3(pc);
			this.setContentPane(p3);
			//frame.setVisible(true);
			cur = p3;
			break;
		}
		
		
	}
}
