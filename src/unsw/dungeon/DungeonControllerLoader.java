package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest, modified by Junhui, Chengbin
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;
    
    private List<ImageView> enemies = new ArrayList<ImageView>();
    private List<ImageView> animals = new ArrayList<ImageView>();
    private List<ImageView> treasures = new ArrayList<ImageView>();
    private List<ImageView> swords = new ArrayList<ImageView>();
    private List<ImageView> invincibilities = new ArrayList<ImageView>();
    private List<ImageView> bombs = new ArrayList<ImageView>();
    private List<Sword> swordList = new ArrayList<Sword>();
    private List<Invincibility> invincibilityList = new ArrayList<Invincibility>(); 
    private List<Treasure> treasureList = new ArrayList<Treasure>(); 
    private List<Bomb> bombList = new ArrayList<Bomb>();
    private List<Enemy> enemyList = new ArrayList<Enemy>(); 
    private List<ImageView> players = new ArrayList<ImageView>();
    private List<Player> playerList = new ArrayList<Player>(); 
    private List<Animal> animalList = new ArrayList<Animal>(); 
    

    private List<ImageView> exits = new ArrayList<ImageView>();


    //Images
    private Image playerImage;
    private Image wallImage;
    private Image exitImage;
    private Image boulderImage;
    private Image switchImage;
    private Image enemyImage;
    private Image treasureImage; 
    private Image swordImage;
    private Image invincibilityImage;
    private Image bombImage;
    private Image animalImage; 

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        swordList = new ArrayList<>();
        entities = new ArrayList<>();
        invincibilityList = new ArrayList<>();
        bombList = new ArrayList<>();
        enemyList = new ArrayList<>(); 
        players = new ArrayList<>();
        playerList = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/brick_brown_0.png");
        exitImage = new Image("/exit.png");
        boulderImage = new Image("/boulder.png");
        switchImage = new Image("/pressure_plate.png");
        enemyImage = new Image("/deep_elf_master_archer.png");
        treasureImage = new Image("/gold_pile.png");
        swordImage = new Image("/greatsword_1_new.png");
        invincibilityImage = new Image("/brilliant_blue_new.png");
        bombImage = new Image("/bomb_lit_3.png");
        animalImage = new Image("/hound.png");
    }

    /**
     * load the player image
     */
    @Override
    public void onLoad(Player player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
        players.add(view);
        playerList.add(player);
        
    }
    /**
     * load the wall image
     */
    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    /**
     * load the exit image
     */
    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
        exits.add(view);
    }
    
    /**
     * delete the exit
     */
    @Override
    public void deleteExit() {
    	for (int i = 0; i < entities.size(); i++) {
    		for (int j = 0; j < exits.size(); j++) {
	    		if(entities.get(i).equals(exits.get(j))) {
	    			entities.get(i).imageProperty().set(null);
	    		}
    		}    
    	}
    }
    
    /**
     * load the boulder image
     */
    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
    }
    
    /**
     * load the enemy image
     */
    @Override 
    public void onLoad(Enemy enemy) {
    	ImageView view = new ImageView(enemyImage);
    	addEntity(enemy, view);
    	enemyList.add(enemy);
    	enemies.add(view);
    }
    
    /**
     * load the treasure image
     */
    @Override 
    public void onLoad(Treasure t) {
    	ImageView view = new ImageView(treasureImage);
    	addEntity(t, view);
    	treasureList.add(t);
    	treasures.add(view);
    }

    /**
     * load the sword image
     */
    @Override 
    public void onLoad(Sword s) {
    	ImageView view = new ImageView(swordImage);
    	addEntity(s, view);
    	swordList.add(s);
    	swords.add(view);
    }
    
    /**
     * load the potion image
     */
    @Override 
    public void onLoad(Invincibility i) {
    	ImageView view = new ImageView(invincibilityImage);
    	addEntity(i, view);
    	invincibilityList.add(i);
    	invincibilities.add(view);
    }
    /**
     * load the bomb image
     */
    @Override 
    public void onLoad(Bomb b){
    	System.out.println("New a new bomb");
    	ImageView view = new ImageView(bombImage);
    	addEntity(b, view);
    	System.out.println("New a new bomb work to here");
    	bombList.add(b);
    	bombs.add(view);
    	System.out.println("New a new bomb work to final step");
    }
    /**
     * load the animal image
     */
    @Override 
    public void onLoad(Animal a){
    	ImageView view = new ImageView(animalImage);
    	addEntity(a, view); 
    	animalList.add(a); 
    	animals.add(view);
    }
    
    /**
     * load the floor switch image
     */
    @Override
    public void onLoad(Switch s) {
        ImageView view = new ImageView(switchImage);
        addEntity(s, view);
    }

    /**
     * add entity info
     * @param entity
     * @param view
     */
    public void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }
    

    /**
     * get the entity info
     * @param entity
     */
    public void getEntity(Entity entity){
    	entities.remove(entity);
    }
    
    /**
     * remove treasure image
     * @param entity
     */
    private void removeTreasure(Entity entity){
    	ImageView view = new ImageView(treasureImage);
    	trackPosition(entity, view);
    	entities.remove(view);
    }
    
    /**
     * get list of view of exit
     */
    @Override
    public List<ImageView> getExits() {
    	return exits;
    }

    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
    }

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }

    /**
     * delete treasure image
     */
	@Override
	public void deleteTreasure(Treasure t) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < treasures.size(); j++) {
				   if(entities.get(i).equals(treasures.get(j))) {
					System.out.println(treasures.get(j));
					if((t.getX() == treasureList.get(j).getX())&&(t.getY() == treasureList.get(j).getY())){
						entities.get(i).imageProperty().set(null);
				    }
				   }
			  }
		}
		
	}

	/**
	 * delete sword image
	 */
	@Override
	public void deleteSword(Sword s){
		// TODO Auto-generated method stub
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < swords.size(); j++) {
				   if(entities.get(i).equals(swords.get(j))) {
					   System.out.println("The sword location is " + s.getX() + " " + s.getY());
					   System.out.println("The swordist  location is " + swordList.get(j).getX() + " " + swordList.get(j).getY());
					   if((s.getX() == swordList.get(j).getX())&&(s.getY() == swordList.get(j).getY())) {
						   entities.get(i).imageProperty().set(null);
					   }
				   }
			  }
		}
	}

	/**
	 * delete potion image
	 */
	@Override
	public void deleteInvincibility(Invincibility iv) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < invincibilities.size(); j++) {
				   if(entities.get(i).equals(invincibilities.get(j))) {
					   if((iv.getX() == invincibilityList.get(j).getX())&&(iv.getY() == invincibilityList.get(j).getY())){
					   entities.get(i).imageProperty().set(null);
					   }
				   }
			  }
		}
		
	}
	
	/**
	 * delete player image
	 */
	@Override 
	public void deletePlayer(Player p) {
		System.out.println("The size is " + players.size());
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < players.size(); j++) {
				   if(entities.get(i).equals(players.get(j))) {
					   if((p.getX() == playerList.get(j).getX())&&(p.getY() == playerList.get(j).getY())) {
						   	entities.get(i).imageProperty().set(null);
				    }
				   }
			  }
		}
	}

	/**
	 * delete bomb image
	 */
	@Override
	public void deleteBomb(Bomb b) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < bombs.size(); j++) {
				   if(entities.get(i).equals(bombs.get(j))) {
					   if((b.getX() == bombList.get(j).getX())&&(b.getY() == bombList.get(j).getY())) {
						   	entities.get(i).imageProperty().set(null);
				    }
				   }
			  }
		}
		
	}

	/**
	 * delete enemies image
	 */
	@Override
	public void deleteEnemies(Enemy e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entities.size(); i++) {
			  for (int j = 0; j < enemies.size(); j++) {
				   if(entities.get(i).equals(enemies.get(j))) {
					   if((e.getX() == enemyList.get(j).getX())&&(e.getY() == enemyList.get(j).getY())) {
						   	entities.get(i).imageProperty().set(null);
					   }
				   }
			  }
		}
	}
	
	/**
	 * delete animals image
	 */
	@Override
	public void deleteAnimals(Animal a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < animals.size(); i++) {
			  for (int j = 0; j < animals.size(); j++) {
				   if(animals.get(i).equals(animals.get(j))) {
					   if((a.getX() == animalList.get(j).getX())&&(a.getY() == animalList.get(j).getY())) {
						   animals.get(i).imageProperty().set(null);
					   }
				   }
			  }
		}
	}

	/**
	 * get treasure image view
	 */
	@Override
	public List<ImageView> getTreasure() {
		// TODO Auto-generated method stub
		return treasures;
	}

	/**
	 * get entities image view
	 */
	@Override
	public List<ImageView> getEntities() {
		// TODO Auto-generated method stub
		return entities;
	}



}
