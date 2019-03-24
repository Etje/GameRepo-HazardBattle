package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class AutomatischGeweer extends Wapens {

	private HazardBattle world;
	private Kogel k;

	public AutomatischGeweer(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/Nieuwe map/automaticGun.png"), world);
		this.world = world;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		// TODO Auto-generated method stub
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
        		this.playGunSounds(this).rewind();
        		this.playGunSounds(this).play();
        		k = new RondeKogel(world);
	        	world.addGameObject(k, (float) getX(), (float) getY());
	        	world.verminderKogels();
        	} else {
        		this.emptyGunSound().rewind();
        		this.emptyGunSound().play();
        	}
        }
        if(key == 'r') {
        	if(world.kogels == 0) {
        		this.reloadSound().rewind();
        		this.reloadSound().play();
        		world.kogels = 5; 
        		world.ververs();
        	}
        }
       
	}

}
