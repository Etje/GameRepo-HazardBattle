package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class GeleKogel extends Kogel implements ICollidableWithGameObjects, ISpeelGeluid {

	private HazardBattle world; 
	
	public GeleKogel(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/Nieuwe map/yellowBullet.png"));
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
	public Sound hitSound(GameObject g) {
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
	public Sound playGunSounds(Wapens w) {
		// TODO Auto-generated method stub
		return null;
	}
}
