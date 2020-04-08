package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javafx.scene.image.ImageView;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest, modified by Junhui, Chengbin
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height, this);

        JSONArray jsonEntities = json.getJSONArray("entities");
        
        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        
        JSONObject jsonGoals = json.getJSONObject("goal-condition");
        
        String goal = jsonGoals.getString("goal");
        
        if(goal.equals("AND")) {
        	JSONArray jsonSubGoals = jsonGoals.getJSONArray("subgoals");
        	for (int i = 0; i < jsonSubGoals.length(); i++) {
                goal = jsonSubGoals.getJSONObject(i).getString("goal");
                dungeon.setGoal(goal);
            }

        } else {
        	dungeon.setGoal(goal);
        }

        return dungeon;
    }
    
    /**
     * load entities
     * @param dungeon the dungeon
     * @param json the json file
     */
    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            dungeon.addWall(wall);
            onLoad(wall);
            entity = wall;
            break;
        // TODO Handle other possible entities
        case "exit":
            Exit exit = new Exit(x, y);
            dungeon.setExit(exit);
            onLoad(exit);
            entity = exit;
            break;
	    case "boulder":
	        Boulder boulder = new Boulder(x, y);
	        dungeon.addBoulder(boulder);
	        onLoad(boulder);
	        entity = boulder;
	        break;
	    case "switch":
	        Switch s = new Switch(x, y);
	        dungeon.addSwitch(s);
	        onLoad(s);
	        entity = s;
	        break;
	    case "enemy":
	    	Enemy e = new Enemy(dungeon, x, y);
	    	dungeon.addEnemy(e);
	    	onLoad(e);
	    	entity = e; 
	    	break;
	    case "treasure":
	    	Treasure t = new Treasure(x, y);
	    	dungeon.addTreasure(t);
	    	onLoad(t);
	    	entity = t; 
	    	break;
	    case "sword":
        	Sword sword = new Sword(dungeon, x, y);
        	dungeon.addSword(sword);
        	onLoad(sword);
        	entity = sword; 
        	break;
	    case "invincibility":
	    	Invincibility i = new Invincibility(dungeon, x, y);
	    	dungeon.addInvincy(i);
	    	onLoad(i);
	    	entity = i;
	    	break;
	    case "bomb":
	    	Bomb b = new Bomb(dungeon, x,y);
	    	dungeon.addBomb(b);
	    	onLoad(b);
	    	entity=b;
	    	break;	
	    case "hound":
	    	Animal h = new Animal(dungeon, x, y);
	    	// Killer h 
//	    	h = new SuperKiller(h);
	    	dungeon.addAnimal(h);
	    	
	    	onLoad(h);
	    	entity = h; 
	    	break; 
	    }
        dungeon.addEntity(entity);
        
    }
    
   

    public abstract void onLoad(Player player);

    public abstract void onLoad(Wall wall);
    
    public abstract void onLoad(Animal hound);
    
    public abstract void onLoad(Exit exit);
    
    public abstract void onLoad(Boulder boulder);
    
    public abstract void onLoad(Switch s);
    
	public abstract void onLoad(Enemy enemy);

	public abstract void onLoad(Treasure t);

	public abstract void onLoad(Sword sword);

	public abstract void onLoad(Invincibility i);

	public abstract void onLoad(Bomb b);
	
	public abstract void deleteEnemies(Enemy e);
	
	public abstract void deleteTreasure(Treasure t);
	
	public abstract void deleteSword(Sword s);
	
	public abstract void deleteInvincibility(Invincibility i);
	
	public abstract void deleteBomb(Bomb b);
	
	public abstract List<ImageView> getTreasure();
	
	public abstract void deletePlayer(Player p);

	public abstract void deleteExit();
	
	public abstract List<ImageView> getEntities();
	
	public abstract List<ImageView> getExits();

	public abstract void deleteAnimals(Animal a);
    // TODO Create additional abstract methods for the other entities

}
