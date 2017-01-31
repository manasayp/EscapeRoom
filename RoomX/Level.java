package RoomX;
import java.util.ArrayList;

//import java.util.ArrayList;

public class Level {
	int level;
	int timer;
	ArrayList<EmptyClue> clues;
	String passcode;
	String imageDir;
	
	public Level(int level){
		if(level == 1){
			this.level = 1;
		    this.timer = 300;
		    this.passcode = "7142";
		    this.imageDir = "images/catoon child room.jpg";
		    clues = new ArrayList<EmptyClue>();
//		    clues.add(new Clue(1, "clue1", 500,165,40,40, "hint1",2));
//		    clues.add(new Clue(2, "clue2", 250,125,45,45, "hint2",1));
//		    clues.add(new Clue(3, "clue3", 85,70,30,30, "hint3",2));
//		    clues.add(new Clue(4,"clue4", 610,390,40,40,"hint4",1));
//		    clues.add(new Clue(5,"clue4", 400,390,40,40,"hint4",0));
//		    clues.add(new Clue(6,"clue4", 200,390,40,40,"hint4",0));
		    
		    clues.add(new PictureClue(1, "clue1", 500,165,40,40, "A grey box","images/Pic1.png"));
		    clues.add(new WordClue(2, "<html><center>how many dwarfs<br> in snowwhite?</center></html>", 250,125,45,45, "Where is my hat?","images/hat.png"));
		    clues.add(new PictureClue(3, "clue3", 85,70,30,30, "I love sports!","images/Pic3.png"));
		    clues.add(new WordClue(4,"<html><center>how many legs<br> does kangaroo have?</center></html>", 610,390,40,40,"Girl's favarate friend.","images/doll.png"));
		    clues.add(new EmptyClue(5, 720,440,40,40,"clue5","images/sad1.jpg"));
		    clues.add(new EmptyClue(6, 170,390,40,40,"clue6","images/sad1.jpg"));
		    
		}
		if(level == 2){
			this.level = 2;
		    this.timer = 30;
		    this.passcode = "7784";
		    this.imageDir = "images/Level2.jpg";
		    clues = new ArrayList<EmptyClue>();
		    clues.add(new WordClue(1, "<html><center>how many parts<br>were there<br>in the movie <br>fast and furious?</center></html>",515,30,50,50, "I need light!","images/light.png"));
		    clues.add(new PictureClue(2, "clue2", 750,130,45,45, "More light!","images/Pic2.jpg"));
		    clues.add(new WordClue(3, "<html><center>how many km <br>in 5 mile</center></html>", 0,290,40,40, "Above the basin","images/tub.png"));
		    clues.add(new PictureClue(4,"clue4", 650,390,40,40,"I'm hungry!","images/Pic4.jpg"));
		    clues.add(new EmptyClue(5,450,390,40,40,"clue5","images/sad1.jpg"));
		    clues.add(new EmptyClue(6,180,390,40,40,"clue6","images/sad1.jpg"));
		    
		}
	}		
}


//{
//	   String img="";
//	   if(level == 1)
//	   {
//		   if(id == 2)
//				   img = "images/hat.png";
//			   else if(id == 3)
//				   img = "images/ball.png";
//			   else if(id == 1)
//				   img = "images/box.png";
//			   else if(id == 4)
//				   img = "images/doll.png";
//			   else
//				   img = "images/solve_clue.jpg";
//		    
//	   }
//	   else
//	   {
//		   if(id == 2)
//				   img = "images/walllight.png";
//			   else if(id == 1)
//				   img = "images/light.png";
//			   else if(id == 3)
//				   img = "images/tub.png";
//			   else if(id == 4)
//				   img = "images/bread.png";
//			   else
//				   img = "images/solve_clue.jpg";    
//	   }
//	   return img;
// }
