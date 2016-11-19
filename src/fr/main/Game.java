package fr.main;


import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;




public class Game extends StateBasedGame {

	
	public Game(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Game() {
		super("pouletz0r");
	}



	public static void main(String[] args) throws SlickException {
		
		//System.setProperty("org.lwjgl.librarypath", new File("lib").getAbsolutePath());
		AppGameContainer app = new AppGameContainer(new Game(),1280,720,true);
		app.setTargetFrameRate(60);
		app.setVSync(true);
		app.setShowFPS(true);
		app.start();
	}




	@Override
	public void initStatesList(GameContainer container) throws SlickException {
//		addState(new Mainmenu());
//		addState(new World());
//		addState(new MenuSortie());
//		addState(new MenuFinPartie());
	}


}
