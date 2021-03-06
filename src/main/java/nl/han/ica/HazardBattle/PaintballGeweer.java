package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

//Klasse PaintballGeweer, welke een subklasse is van Wapen.java. 
public class PaintballGeweer extends Wapen {

	private HazardBattle world; 

	public PaintballGeweer(HazardBattle hazardBattle) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/Nieuwe map/paintballGun.png"), hazardBattle);
		this.world = hazardBattle; 
	}

	@Override
	public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == world.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == world.DOWN) {
            setDirectionSpeed(180, speed);
        } 
        if (keyCode == world.LEFT) {
            setDirectionSpeed(270, speed);
        }
        if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
        }
        if(keyCode == ' ') {
        	if(world.kogels != 0) {
        		playGunSounds(this).rewind();
        		playGunSounds(this).play();
        		Kogel k = new ShotgunKogel(world);
	        	world.addGameObject(k, (float) getX(), (float) getY());
	        	world.verminderKogels();
        	} else {
        		emptyGunSound().rewind();
        		emptyGunSound().play();
        	}
        }
        if(key == 'r') {
        	if(world.kogels == 0) {
        		reloadSound().rewind();
        		reloadSound().play();
        		world.kogels = 5; 
        		world.ververs();
        	}
        }
	}

}
