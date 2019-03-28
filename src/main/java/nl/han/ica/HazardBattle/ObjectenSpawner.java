package nl.han.ica.HazardBattle;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

public class ObjectenSpawner extends SpawnerVariable implements IAlarmListener {
	
	private float soldatenPerSeconden; 
	private int min, max; 
	private Random random, soldaatRandomNumber; 
	private HazardBattle hazardBattle; 
	AbstractObject s = null;
	
	public ObjectenSpawner(HazardBattle world, float objectPerSecond) {
		this.soldatenPerSeconden = setAmount(objectPerSecond); 
		this.hazardBattle = setWorld(world); 
		this.random = new Random();
		this.soldaatRandomNumber = new Random();
		alarmObject(); 
	} 
	
	@Override
	public void triggerAlarm(String alarmName) {
		// TODO Auto-generated method stub
		
		int random = setNextRandom(3);
		
		if(random == 0) {
			s = new Soldaat(hazardBattle);
		} else if(random == 1) {
			s = new Schip(hazardBattle);
		} else if(random == 2) {
			s = new Geest(hazardBattle);
		}

		this.min = (int) (0 + s.getHeight());
		this.max = (int) (hazardBattle.gameHoogte - s.getHeight());
		hazardBattle.addGameObject(s, 0, setRandom((max - min) + 1) + min);
        alarmObject();
	} 

	@Override
	public void alarmObject() {
        Alarm alarm = new Alarm("Nieuwe object",1/setAmount(soldatenPerSeconden));
        alarm.addTarget((IAlarmListener) this);
        alarm.start();
	}

	@Override
	public float setAmount(float XAmount) {
		// TODO Auto-generated method stub
		this.soldatenPerSeconden = XAmount; 
		return soldatenPerSeconden;
	}

	@Override
	public int setRandom(int x) {
		// TODO Auto-generated method stub
		int cijfer = random.nextInt(x);
		return cijfer;
	}


	@Override
	public HazardBattle setWorld(HazardBattle world) {
		// TODO Auto-generated method stub
		this.hazardBattle = world;
		return this.hazardBattle;
	}

	@Override
	public int setNextRandom(int y) {
		// TODO Auto-generated method stub
		int nextCijfer = soldaatRandomNumber.nextInt(y);
		return nextCijfer; 
	}

}
