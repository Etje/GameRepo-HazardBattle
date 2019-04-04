package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.HazardBattle.Tiles.LoopbandTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

//subklasse Schip, welke erft van de zelfgemaakte AbstractObject klasse. 
//Deze klasse is 1 van de 3 vijand klasse, en heeft dus een andere implementatie dan de andere 2 klasses

public class Schip extends AbstractObject {

	private HazardBattle world;

	public Schip(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/ship.png"));
		this.world = world;
		setxSpeed(3f);
	}


	@Override
	public void mousePressed(int x, int y, int button) {
			
	}

	@Override
	public void update() {
		if(getX() == world.gameBreedte) {
			world.verminderLevens(2);
			world.deleteGameObject(this);		
		} else if(world.haalLevensOp() <= 0) {
			world.exit();
		}
	}

}
