package fr.vision;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.circle.EntityCircle;
import entity.movable.circle.Character;
import entity.movable.circle.MovableCircle;
import entity.movable.circle.Player;
import entity.movable.rectangle.MovableRectangle;
import fr.util.Collisions;

public class Area {
	
	private Character character;
	private ArrayList<Entity> visibleEntities;
	private int size;
	
	public Area(Character character, int size){
		this.character = character;
		this.size = size;
	}

	
	/*
	 * 1----2 > RAINBOWDASH IS BEST PONY
	 * |	|
	 * 3----4
	 * v
	 */
	public void updateViewField(){
		ArrayList<Entity> entities = character.getWorld().getEntities();
		visibleEntities = new ArrayList<Entity>();
		
		/*
		private ArrayList<Wall> walls;
		private ArrayList<Guard> guards;
		private ArrayList<Item> items;
		private ArrayList<Projectile> projectiles;
		*/
		
		double tmpX = character.getX();
		double tmpY = character.getY();
		
		EntityCircle tmpCircle = new EntityCircle(0, 0);
		tmpCircle.setRadius(1);
		for( double theta = character.getOrientation() - character.getFieldOfView(); theta <= character.getOrientation() + character.getFieldOfView(); theta++ ){
			double d = 0;
			Boolean continueD = true;
			while( d <= size || continueD){
				for( Entity entity : entities ){
					tmpCircle.setX( tmpCircle.getX() + Math.sin(theta) );
					tmpCircle.setY( tmpCircle.getY() + Math.cos(theta) );
					d = norm( tmpX, tmpCircle.getX(), tmpY, tmpCircle.getY() );
					if( entity instanceof MovableRectangle ){
						if( Collisions.isCollision(tmpCircle, (MovableRectangle)entity) ){
							visibleEntities.add(entity);
							continueD = false;
						}
					} else if( entity instanceof MovableCircle){
						if( Collisions.isCollision(tmpCircle, (MovableCircle)entity) ){
							visibleEntities.add(entity);
							continueD = false;
						}
					} 
				}
			}
		}
		
		if( character instanceof Player ){
			changeState(entities, visibleEntities);
		}
		
	}
	
	private void changeState(ArrayList<Entity> all, ArrayList<Entity> visible) {
		for(Entity e : all){
			if(visible.contains(e)){
				System.out.println("ok");
				e.setVisible(true);
			} else {
				e.setVisible(false);
			}
		}
	}

	private double norm(double xA, double xB, double yA, double yB){
		return Math.sqrt( Math.pow(xA-xB,2) + Math.pow(yA-yB,2) );
	}

	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		arg3.setColor(Color.pink);
		System.out.println(character.getWorld().getGuards().get(0).getVisible());
		System.out.println( character.getX() + character.getRadius() );
		System.out.println( character.getY() + character.getRadius() ); 
		System.out.println( character.getX() + character.getRadius() + size * Math.cos( character.getOrientation() - character.getFieldOfView() ) );
		System.out.println( character.getY() + character.getRadius() + size * Math.sin( character.getOrientation() - character.getFieldOfView() ) );
		arg3.drawLine((float)(character.getX() - character.getRadius()), (float)(character.getY() - character.getRadius()), (float)(character.getX() - character.getRadius() + size * Math.tan( character.getOrientation() + character.getFieldOfView() ) ), (float)(character.getY() - character.getRadius() + size * Math.sin( character.getOrientation() + character.getFieldOfView() ) ) );
		arg3.drawLine((float)(character.getX() - character.getRadius()), (float)(character.getY() - character.getRadius()), (float)(character.getX() - character.getRadius() + size * Math.tan( character.getOrientation() + character.getFieldOfView() ) ), (float)(character.getY() - character.getRadius()/2 - size * Math.sin( character.getOrientation() + character.getFieldOfView() ) ) );
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public Character getCharacter() {
		return character;
	}


	public ArrayList<Entity> getVisibleEntities() {
		return visibleEntities;
	}

	
}


