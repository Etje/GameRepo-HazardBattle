package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public interface ISpeelGeluid {

	public abstract Sound playGunSounds(Wapens w); 
	public abstract Sound emptyGunSound();
	public abstract Sound reloadSound();
	public abstract Sound hitSound(GameObject g); 
	
}

