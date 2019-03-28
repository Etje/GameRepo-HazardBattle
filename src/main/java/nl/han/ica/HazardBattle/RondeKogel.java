package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class RondeKogel extends Kogel {

	private HazardBattle world;

	public RondeKogel(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/Nieuwe map/RoundBullet.png"), world);
		this.world = world;
		setxSpeed(-2f);
		// TODO Auto-generated constructor stub
	}
	
}
