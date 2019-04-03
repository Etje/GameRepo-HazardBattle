package nl.han.ica.HazardBattle;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.IPersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

//hoofdklasse van het spel, erft van GameEngine (klasse uit aangeleverde game engine)
@SuppressWarnings("serial")
public class HazardBattle extends GameEngine {

	//variables, die gelden binnen de klasse
	private IPersistence persistence;
	private ObjectenSpawner objects;
	private ItemSpawner verrassingen;
	private Text scoreText, levensText, kogelText;
	private int soldatenGedood, verrassingsSpawnerteller, levens;
	public int kogels;
    public int gameHoogte, gameBreedte;
    
    //functie die het spel uiteindelijk uitvoerd
	public static void main(String[] args) {
		HazardBattle b = new HazardBattle();
        b.runSketch();
	}

	//setup gegevens van het spel
	@Override
	public void setupGame() {
		
		this.gameBreedte = 1200; 
		this.gameHoogte = 900; 
		
    	maakSpeler(); 
    	soldatenSpawner();
    	itemSpawner();
    	objectsMap();
		maakAchtergrond(gameBreedte, gameHoogte); 
		tekenTextEnDashboard(gameBreedte, gameHoogte);
		dataBestand();
		ververs();
		
	} 
	
	//speler word aangemaakt
	private void maakSpeler() {
		//Keuze uit een HandGeweer, PaintballGeweer en AutomatischGeweer. 
		//alle 3 krijgen de parameter 'this' mee
	    Wapen p = new HandGeweer(this); 
        addGameObject(p, gameBreedte / 1.35f, 0 + p.getHeight());
	}
	
	//het aantal soldate die je gedood hebt word weggeschreven in een bestand
	private void dataBestand() {
        persistence = new FilePersistence("src/main/java/nl/han/ica/HazardBattle/media/soldierKilled.txt");
        if (persistence.fileExists()) {
        	soldatenGedood = Integer.parseInt(persistence.loadDataString());
    		ververs();
        }
	}

	//dashboard, met bijbehorende text objecten worden aangemaakt
	private void tekenTextEnDashboard(int gameBreedte, int gameHoogte) {
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

	//het aantal levens, wat de speler heeft, word bij aanroep van onderstaande functie op 10 gezet. 
	public int zetLevens() {
		return this.levens = 10;
	}

	//het aantal kogels word bij aanroep van deze functie op 5 gezet.
	public int zetKogel() {
		return this.kogels = 5;
	}

	//de achtergrond van het spel word gemaakt
	private void maakAchtergrond(int gameBreedte, int gameHoogte) {
        View view = new View(gameBreedte,gameHoogte);
        view.setBackground(loadImage("src/main/java/nl/han/ica/HazardBattle/media/background2.jpg"));

        setView(view);
        size(gameBreedte, gameHoogte);
	}

	//de map met objecten word gemaakt
	private void objectsMap() {
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

	//de spawner die de levensdrankjes en munitie maakt word aangemaakt.
	private void itemSpawner() {
		verrassingen = new ItemSpawner(this, (float) 0.25);
	}

	//spawner die de vijanden, welke over het scherm lopen, word aangemaakt
	private void soldatenSpawner() {
		objects = new ObjectenSpawner(this, (float) 0.5);
	}

	@Override
	public void update() {
		
	}

	//wanneer een soldaat omver geschoten word, wordt deze methode aangeroepen en word de variabel 'soldatenGedood' opgehoogd, en weggeschreven in een bestand.
	public void hoogGedodeSoldatenOp() {
		soldatenGedood++;
		persistence.saveData(Integer.toString(soldatenGedood));
		ververs();
	}

	//de teller voor de verrassingen wordt opgehoogt 
	public int hoogVerrassingSpawnerTellerOp() {
		return verrassingsSpawnerteller++;
	}

	//het aantal kogels word met 1 verminderd
	public void verminderKogels() {
		this.kogels--;
		ververs();
	}
	
	//het aantal levens word met 1 verminderd
	public void verminderLevens(int i) {
		this.levens -= i; 
		ververs();
	}
	
	//het aantal levens word opgehaald
	public int haalLevensOp() {
		return levens; 
	}

	//de text objecten worden ververst 
	public void ververs() {
    	kogelText.setText("Je hebt nog " + kogels + " kogels", gameBreedte / 11, 15);
    	scoreText.setText("Je hebt " + soldatenGedood + " soldiers gekilt", gameBreedte / 2, 15);
    	levensText.setText("Je hebt nog maar " + levens + " levens", gameBreedte / 1.12f, 15);
	}

	public int haalVerrassingSpawnertellerOp() {
		return verrassingsSpawnerteller;
	}

	public void hoogKogelsMetTienOp() {
		this.kogels = 10; 
		ververs();
		
	}
}
