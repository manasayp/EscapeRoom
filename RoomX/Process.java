package RoomX;

public class Process {

	Frame test;
	static PanelController pc;
	public static void main(String[] args) {
		pc = new PanelController();
		Frame test = new Frame(pc);
		pc.addFrame(test);
		pc.switchPanel(0, 0);
		test.setVisible(true);
	}

}
