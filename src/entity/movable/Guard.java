package entity.movable;

import org.newdawn.slick.Image;

public class Guard extends Character {

	protected Area visualField;
	
	public Guard(double x, double y, double sx, double sy, Image im, Area visuFie) {
		super(x, y, sx, sy, im);
		this.visualField=visuFie;
	}

	//------------------------------Get--------------
	
	public Area getVisualField() {
		return visualField;
	}

	//------------------------------Set--------------
	
	public void setVisualField(Area visualField) {
		this.visualField = visualField;
	}

	
}
