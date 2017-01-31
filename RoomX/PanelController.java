package RoomX;

import javax.swing.JPanel;

public class PanelController {
	P0 p0;
	P1 p1;
	P2 p2;
	P3 p3;
	JPanel cur;
	Frame frame;
	
	public PanelController(){
		cur = null;
	}
	
	public void addFrame(Frame frame){
		this.frame = frame;
	}
	
	public void addPanel(JPanel jp){
		
		if(jp instanceof P0){
			this.p0 = (P0) jp;
		}else if(jp instanceof P1){
			this.p1 = (P1) jp;
		}else if(jp instanceof P2){
			this.p2 = (P2) jp;
		}else if(jp instanceof P3){
			this.p3 = (P3) jp;
		}
	}
	
	public void switchPanel(int next, int acc){
		
		frame.switchTo(next, acc);
	}
	

}
