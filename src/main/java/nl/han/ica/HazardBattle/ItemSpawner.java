package nl.han.ica.HazardBattle;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

//Klasse ItemSpawner, welke erft van de zelfgemaakte SpawnerVariable klass, en IAlarmListener implementeerd.

public class ItemSpawner extends SpawnerVariable implements IAlarmListener {
	
	private float amount; 
	private HazardBattle world; 
	private Random random = new Random(); 
	private Random nextRandom = new Random();
	
	public ItemSpawner(HazardBattle hazardBattle, float drankjePerseconden) {
		this.amount = setAmount(drankjePerseconden);
		this.world = setWorld(hazardBattle);
		alarmObject(); 
	} 
	
	@Override
	public void triggerAlarm(String alarmName) {
		
		if(world.haalVerrassingSpawnertellerOp() >= 5 && world.haalVerrassingSpawnertellerOp() <= 15) {
			AbstractObject p = new LevensDrankje(world);
	        AbstractObject a = new Munitie(world);  
	        world.addGameObject(p, setRandom(world.gameBreedte / 2), setRandom(world.gameHoogte / 2));	
	        world.addGameObject(a, setNextRandom(world.gameBreedte / 2), setNextRandom(world.gameHoogte / 2));
		}
		
		alarmObject();
	} 

	@Override
	public void alarmObject() {
        Alarm alarm = new Alarm("Nieuwe potion",2/setAmount(amount));
        alarm.addTarget(this);
        alarm.start();
	}
	
	@Override
	public int setRandom(int x) {
		int cijfer = random.nextInt(x);
		return cijfer;
	}
	
	@Override
	public int setNextRandom(int y) {
		int nextCijfer = nextRandom.nextInt(y);
		return nextCijfer; 
	}
	
	@Override
	public HazardBattle setWorld(HazardBattle world) {
		this.world = world;
		return world;
	}

	public float setAmount(float XAmount){
		this.amount = XAmount; 
		return amount; 
	}

}
