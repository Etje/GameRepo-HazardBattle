package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

//Interface, welke de abstracte Sound methodes aanmaakt. 
//Deze methodes worden dus verwacht in elke class die ISpeelGeluid implementeert.

public interface ISpeelGeluid {

	public abstract Sound playGunSounds(Wapen w); 
	public abstract Sound emptyGunSound();
	public abstract Sound reloadSound();
	public abstract Sound hitSound(GameObject g); 
	
}

