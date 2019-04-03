package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PConstants;
import processing.core.PGraphics;

//Text klasse, welke erft van GameObject. 
//Deze klasse zorgt voor het tekenen van de textObjecten. 
public class Text extends GameObject {
	
    private String text;
    private float x, y;

    public Text(String text) {
        this.text=text;
    }

    public void setText(String text, float x, float y) {
        this.text=text;
        this.x = x; 
        this.y = y;
    }
    
	@Override
	public void update() {
		
	}

	@Override
	public void draw(PGraphics g) {
		
        g.textAlign(PConstants.CENTER);
        g.textSize(15);
        g.text(text,x,y);
	}
}
