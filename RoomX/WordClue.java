package RoomX;

public class WordClue extends EmptyClue{
	String hint;
    public WordClue(int id, String content, int hpos, int vpos, int hsize, int vsize, String hint, String background){
        super(id, hpos, vpos, hsize, vsize, content, background);
        this.hint = hint;
        super.found = false;
    }	
}
