package nl.han.ica.HazardBattle;

import nl.han.ica.HazardBattle.HazardBattle;

import nl.han.ica.HazardBattle.ISpeelGeluid;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public abstract class Wapen extends AnimatedSpriteObject implements ISpeelGeluid {
	
	private HazardBattle world;
	private int size = 25;

	public Wapen(Sprite sprite, HazardBattle world) {
		super(sprite, 1);
        setCurrentFrameIndex(0);
        setFriction(0.1f);
        this.world = world;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth() - size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }
	}
	
	public abstract void keyPressed(int keyCode, char key);

	@Override
	public Sound hitSound(GameObject g) {
		return null;
	}
	
	@Override
	public Sound reloadSound() {
		// TODO Auto-generated method stub
		return new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/reload-sound.mp3");
	}

	@Override
	public Sound emptyGunSound() {
		// TODO Auto-generated method stub
		return new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/empty-gun-sound.wav");
	} 

	@Override
	public Sound playGunSounds(Wapen w) {
		// TODO Auto-generated method stub
		Sound playSound = null;
		
		if(w instanceof AutomatischGeweer) {
			playSound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/automatic.mp3");	
		} else if(w instanceof HandGeweer) {
			playSound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/gunshot.mp3");
		} else if(w instanceof PaintballGeweer) {
			playSound = new Sound(world, "src/main/java/nl/han/ica/HazardBattle/media/paintball.mp3");
		}
		
		return playSound;
	}
}
