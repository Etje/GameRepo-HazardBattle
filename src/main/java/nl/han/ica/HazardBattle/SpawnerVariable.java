package nl.han.ica.HazardBattle;

import java.util.Random;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

public abstract class SpawnerVariable {
	
	public abstract void alarmObject();
	public abstract float setAmount(float XAmount);
	public abstract int setRandom(int x);
	public abstract int setNextRandom(int y);
	public abstract HazardBattle setWorld(HazardBattle world);
	
}

