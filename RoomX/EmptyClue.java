package RoomX;

public class EmptyClue extends Clue{

	String content;
    //public Clue(int type, String content, int found, String hint, int vpos, int hpos, int vsize, int hsize){
    public EmptyClue(int id, int hpos, int vpos, int hsize, int vsize, String content, String background){
        super(id, hpos,vpos, hsize,vsize, background);
        this.content = content;
        super.found = true;
   	}
}
