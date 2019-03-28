package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public abstract class Kogel extends AnimatedSpriteObject implements ISpeelGeluid, ICollidableWithGameObjects {
	
	private HazardBattle world;

	public Kogel(Sprite sprite, HazardBattle world) {
		super(sprite, 1);
		this.world = world;
		setxSpeed(-2f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sound playGunSounds(Wapen w) {
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
		System.out.println(g);
		Sound sound = null; 
		
		if(g instanceof Soldaat) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/splats.mp3");
		} else if(g instanceof Schip) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/gunshot.mp3");
		} else if(g instanceof Geest) {
			sound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/automatic.mp3");
		}
		
		return sound;
	}
}
