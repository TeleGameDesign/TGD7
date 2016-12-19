package nicotesting;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.circles.Player;
import fr.rectangles.Wall;

public class Link {
	
	private Line line;
	private Player player;
	private GuardTest guard;
	private boolean wall;//if there is a wall between them
	
	public Link(Player player,GuardTest guard){
		this.line = new Line(player.getCenterX(), player.getCenterY(), guard.getCenterX(), guard.getCenterY());
		this.player=player;
		this.guard=guard;
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException {
		this.line =new Line(player.getCenterX(), player.getCenterY(), guard.getCenterX(), guard.getCenterY());
		wall = false;
		for (Wall w:World.getWalls()){
			if (line.intersects(w)){
				wall =true;
			}
		}
		
		
		
		if ((guard.getArea().contains(player.getCenterX(), player.getCenterY()))&&(!wall)&&(fr.util.Collisions.distance(player.getCenter(), guard.getCenter())<400)){
			guard.showAlert();
		}else {guard.stopAlert();}
	}

	public  void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		arg3.setColor(Color.blue);
		arg3.drawLine(this.player.getCenterX(), player.getCenterY(), guard.getCenterX(), guard.getCenterY());
	}
}
