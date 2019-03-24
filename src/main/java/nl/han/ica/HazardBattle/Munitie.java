package nl.han.ica.HazardBattle;

import java.util.List;
import java.util.Random;

import nl.han.ica.HazardBattle.HazardBattle;
import nl.han.ica.HazardBattle.AbstractObject;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Munitie extends AbstractObject {

	private HazardBattle world; 
	private boolean xAs; 
	private boolean yAs; 
	private Random random; 
	
	public Munitie(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/munitions.png"));
		this.world = world;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(int x, int y, int button) {
		this.xAs = x > getX() && x < getX() + getWidth(); 
		this.yAs = y > getY() && y < getY() + getHeight();
		
		if(xAs && yAs && button == 37) {
			world.deleteGameObject(this);
			world.hoogKogelsMetTienOp(); 
			world.ververs();
		}
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		// TODO Auto-generated method stub
		
	}

}
