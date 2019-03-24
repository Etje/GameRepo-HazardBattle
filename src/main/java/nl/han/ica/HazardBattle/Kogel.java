package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public abstract class Kogel extends AnimatedSpriteObject implements ISpeelGeluid {
	
	private HazardBattle world;

	public Kogel(Sprite sprite) {
		super(sprite, 1);
		this.world = world;
		setxSpeed(-2f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sound playGunSounds(Wapens w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sound emptyGunSound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sound reloadSound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sound hitSound(GameObject g) {
		// TODO Auto-generated method stub
		Sound sound = null; 
		
		if(g instanceof Soldaat) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/splats.mp3");
		} else if(g instanceof Schip) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/gunshot.mp3");
		} else if(g instanceof Geest) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/reload-sound.mp3");
		}
		
		return sound;
	}
}
