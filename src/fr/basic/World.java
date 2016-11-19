package fr.basic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.item.Item;
import entity.movable.Guard;
import entity.movable.Player;
import entity.movable.Projectile;
import entity.wall.Wall;
import fr.util.Chrono;

public class World extends BasicGameState{

	private int ID;
	private Chrono chrono;
	private Player player;
	private StateBasedGame game;
	private ArrayList<Wall> walls;
	private ArrayList<Guard> guards;
	private ArrayList<Item> items;
	private ArrayList<Projectile> projectiles;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void keyPressed(int key, char c){
		
	}
	
	public void keyReleased(int key, char c){
		
	}
	
	public ArrayList<Wall> getWalls(){
		return walls;
	}
	
	public ArrayList<Guard> getGuards(){
		return guards;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void reset(){
		
	}
	
}
