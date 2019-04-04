package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.HazardBattle.Tiles.LoopbandTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PGraphics;
import processing.core.PImage;

//zelf gemaakte abstracte klasse, welke erft van de klasse GameObject. 
public abstract class AbstractObject extends GameObject implements ICollidableWithTiles  {

	private Sprite sprite;
	
	/**
	 * Create a new SpriteObject with a Sprite object.
	 * @param sprite
	 */
	public AbstractObject(Sprite sprite) {
		super();
		
		this.sprite = sprite;
		
		setWidth(sprite.getWidth());
		setHeight(sprite.getHeight());
	}
	
	@Override
	public void draw(PGraphics g){g.image(sprite.getPImage(), x, y);}
	public PImage getImage(){return sprite.getPImage();}
	public abstract void mousePressed(int x, int y, int button);
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		
        for (CollidedTile ct : collidedTiles) {
            
            if (ct.theTile instanceof LoopbandTile) {
            	this.setX(getX() + 14);
            	setxSpeed(1f);
            }
        }
        
	}
}
