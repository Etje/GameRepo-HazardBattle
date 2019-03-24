package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

@SuppressWarnings("serial")
public class HazardBattle extends GameEngine {

	private IPersistence persistence;
	private SoldatenSpawner objects;
	private LevensDrankjeSpawner verrassingen;
	private Text scoreText, levensText, kogelText;
	private int soldatenGedood, verrassingsSpawnerteller, levens;
	public int kogels;
    public int gameHoogte, gameBreedte;
    // bij onderstaand variable kunt u kiezen uit 'paintball geweer', 'automatisch geweer', en 'hand geweer'
    private int typeWapen = 0; 
    private Wapens p; 
    
	public static void main(String[] args) {
		HazardBattle b = new HazardBattle();
        b.runSketch();
	}

	@Override
	public void setupGame() {
		// TODO Auto-generated method stub
		
		this.gameBreedte = 1200; 
		this.gameHoogte = 900; 
		
    	maakSpeler(); 
    	soldatenSpawner();
    	levensDrankjeSpawner();
    	objectsMap();
		maakAchtergrond(gameBreedte, gameHoogte); 
		tekenTextEnDashboard(gameBreedte, gameHoogte);
		dataBestand();	
		
	} 
	
	private void maakSpeler() {
		// TODO Auto-generated method stub
		
    	switch(typeWapen) {
	    	case 0: 
	    		p = new HandGeweer(this);
	    		break; 
	    	case 1: 
	    		p = new AutomatischGeweer(this);
	    		break; 
	    	case 2: 
	    		p = new PaintballGeweer(this);
    	}
    	
        addGameObject(p, gameBreedte / 1.35f, 0 + p.getHeight());
	}
	
	private void dataBestand() {
		// TODO Auto-generated method stub
        persistence = new FilePersistence("src/main/java/nl/han/ica/HazardBattle/media/soldierKilled.txt");
        if (persistence.fileExists()) {
        	soldatenGedood = Integer.parseInt(persistence.loadDataString());
    		ververs();
        }
	}

	private void tekenTextEnDashboard(int gameBreedte, int gameHoogte) {
		// TODO Auto-generated method stub
    	zetLevens();
    	zetKogel();
        Dashboard dashboard = new Dashboard(0,0, gameBreedte, gameHoogte);
        scoreText = new Text("");
        kogelText = new Text("");
        levensText = new Text("");
        
        dashboard.addGameObject(scoreText);
        dashboard.addGameObject(kogelText);
        dashboard.addGameObject(levensText);
        addDashboard(dashboard);
        maakAchtergrond(gameBreedte, gameHoogte); 
	}

	public int zetLevens() {
		// TODO Auto-generated method stub
		return this.levens = 10;
	}

	public int zetKogel() {
		// TODO Auto-generated method stub
		return this.kogels = 5;
	}

	private void maakAchtergrond(int gameBreedte, int gameHoogte) {
		// TODO Auto-generated method stub
        View view = new View(gameBreedte,gameHoogte);
        view.setBackground(loadImage("src/main/java/nl/han/ica/HazardBattle/media/background2.jpg"));

        setView(view);
        size(gameBreedte, gameHoogte);
	}

	private void objectsMap() {
		// TODO Auto-generated method stub
        Sprite treeSprite = new Sprite("src/main/java/nl/han/ica/HazardBattle/media/tree.png");	
        TileType<nl.han.ica.HazardBattle.Tiles.BoomTile> BoomTileType = new TileType<>(nl.han.ica.HazardBattle.Tiles.BoomTile.class, treeSprite);
        
        Sprite treadMillSprite = new Sprite("src/main/java/nl/han/ica/HazardBattle/media/treadmill.png");	
        TileType<nl.han.ica.HazardBattle.Tiles.LoopbandTile> LoopbandTileType = new TileType<>(nl.han.ica.HazardBattle.Tiles.LoopbandTile.class, treadMillSprite);

        TileType[] tileTypes = { BoomTileType, LoopbandTileType };
        int tileSize=50;
        int tilesMap[][]={
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}

	private void levensDrankjeSpawner() {
		// TODO Auto-generated method stub
		verrassingen = new LevensDrankjeSpawner(this, (float) 0.25);
	}

	private void soldatenSpawner() {
		// TODO Auto-generated method stub
		objects = new SoldatenSpawner(this, (float) 0.5);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void hoogGedodeSoldatenOp() {
		// TODO Auto-generated method stub
		soldatenGedood++;
		persistence.saveData(Integer.toString(soldatenGedood));
		ververs();
	}

	public int hoogVerrassingSpawnerTellerOp() {
		// TODO Auto-generated method stub
		return verrassingsSpawnerteller++;
	}

	public void verminderKogels() {
		// TODO Auto-generated method stub
		this.kogels--;
		ververs();
	}
	
	public void verminderLevens(int i) {
		this.levens -= i; 
		ververs();
	}
	
	public int haalLevensOp() {
		return levens; 
	}

	public void ververs() {
		// TODO Auto-generated method stub
    	kogelText.setText("Je hebt nog " + kogels + " kogels", gameBreedte / 11, 15);
    	scoreText.setText("Je hebt " + soldatenGedood + " soldiers gekilt", gameBreedte / 2, 15);
    	levensText.setText("Je hebt nog maar " + levens + " levens", gameBreedte / 1.12f, 15);
	}

	public int haalVerrassingSpawnertellerOp() {
		// TODO Auto-generated method stub
		return verrassingsSpawnerteller;
	}

	public void hoogKogelsMetTienOp() {
		// TODO Auto-generated method stub
		this.kogels = 10; 
		ververs();
		
	}
}
