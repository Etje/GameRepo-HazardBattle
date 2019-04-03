package nl.han.ica.HazardBattle;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

//Abstracte klasse SpawnerVariable, welke abstracte methodes heeft. 
//dus, elke klasse die erft van deze klasse (SpawnerVariable) krijgt alle methodes. 
public abstract class SpawnerVariable {
	
	public abstract void alarmObject();
	public abstract float setAmount(float XAmount);
	public abstract int setRandom(int x);
	public abstract int setNextRandom(int y);
	public abstract HazardBattle setWorld(HazardBattle world);
	
}

