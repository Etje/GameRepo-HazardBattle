package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

//Abstracte klasse Kogel, welke alle implementatie bevat voor de kogels. 
//Deze klasse implementeerd ISpeelGeluid en ICollidableWithGameObjects.
public abstract class Kogel extends AnimatedSpriteObject implements ISpeelGeluid, ICollidableWithGameObjects {
	
	private HazardBattle world;

	public Kogel(Sprite sprite, HazardBattle world) {
		super(sprite, 1);
		this.world = world;
		setxSpeed(-2f);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g:collidedGameObjects) {
            if (g instanceof AbstractObject) {
            	hitSound(g).rewind();
            	hitSound(g).play();
                world.deleteGameObject(g);
                world.deleteGameObject(this);
                world.hoogGedodeSoldatenOp();
                world.hoogVerrassingSpawnerTellerOp();
            }
        }
	}

	@Override
	public void update() {
		
	}

	@Override
	public Sound playGunSounds(Wapen w) {
		return null;
	}

	@Override
	public Sound emptyGunSound() {
		return null;
	}

	@Override
	public Sound reloadSound() {
		return null;
	}

	@Override
	public Sound hitSound(GameObject g) {
		Sound sound = null; 
		
		if(g instanceof Soldaat) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/splats.mp3");
		} else if(g instanceof Schip) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/splash_4.wav");
		} else if(g instanceof Geest) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/splash_3.wav");
		} else if(g instanceof Munitie) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/fade.mp3");
		} else if(g instanceof LevensDrankje) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/fade.mp3");		
		}
		
		return sound;
	}

	public HazardBattle getWorld() {
		return world;
	}

	public void setWorld(HazardBattle world) {
		this.world = world;
	}
}
