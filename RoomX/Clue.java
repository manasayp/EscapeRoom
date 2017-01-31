package RoomX;
public abstract class Clue {

	boolean found;
	int vpos;
	int hpos;
	int vsize;
	int hsize;
	int id;
	String background;
    //public Clue(int type, String content, int found, String hint, int vpos, int hpos, int vsize, int hsize){
    public Clue(int id, int hpos, int vpos, int hsize, int vsize, String background){
        this.id = id;
    	this.vpos = vpos;
    	this.hpos = hpos;
    	this.vsize = vsize;
    	this.hsize = hsize;
    	this.found = true;
    	this.background = background;
    	
   	}
    
}