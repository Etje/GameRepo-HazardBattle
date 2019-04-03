package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.HazardBattle.HazardBattle;
import nl.han.ica.HazardBattle.AbstractObject;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

//Klasse LevensDrankje, welke erft van AbstractObject. 

public class LevensDrankje extends AbstractObject {

	private HazardBattle world; 
	boolean xAs; 
	boolean yAs; 
	
	public LevensDrankje(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/potion.png"));
		this.world = world;
	}
	
	@Override
	public void mousePressed(int x, int y, int button) {
		this.xAs = x > getX() && x < getX() + getWidth(); 
		this.yAs = y > getY() && y < getY() + getHeight();
		
		if(xAs && yAs && button == 37) {
			world.deleteGameObject(this);
			world.zetLevens(); 
			world.ververs();
		}
	}

	@Override
	public void update() {
		
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		
	}

}
