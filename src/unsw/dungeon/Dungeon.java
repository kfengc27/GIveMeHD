/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest, modified by Junhui and Chengbin
 *
 */
public class Dungeon implements Subject{

    private int width, height;
    private List<Entity> entities;
    private List<Wall> walls = new ArrayList<Wall>();
    private List<Boulder> boulders = new ArrayList<Boulder>();
    private List<Switch> ss = new ArrayList<Switch>();
    private Player player;
    private Exit exit;
    private List<String> goals = new ArrayList<String>();
    private List<Enemy> enemyList = new ArrayList<Enemy>();
    private List<Treasure> treasureList = new ArrayList<Treasure>();
    private List<Sword> swordList = new ArrayList<Sword>();
    private List<Invincibility> invincibilityList = new ArrayList<Invincibility>();
    private List<Bomb> bombList = new ArrayList<Bomb>();
    private List<Animal> animalList = new ArrayList<Animal>(); 
    private DungeonLoader dungeonLoader = null;
    private ArrayList<PlayerObserver> observers;
    private ArrayList<Thread> animalThreadList; 
    private ArrayList<Thread> enemyThreadList;
    private boolean running; 
    
    public int speed; 

    public Dungeon(int width, int height, DungeonLoader dungeonLoader) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.dungeonLoader = dungeonLoader;
        this.speed = 3000;
        this.observers = new ArrayList<>();
        this.running = true; 

    }
    
    /**
     * kill the player
     * the player will be removed
     */
    public void killPlayer() {
    	this.dungeonLoader.deletePlayer(this.player);
    	this.player = null; 

    }
    
    /**
     * speed up
     */
    public void upSpeed() {
    	this.speed+=200;
    }
    /**
     * lower the speed
     */
    public void downSpeed() {
    	if(this.speed>200) {
    		this.speed-=200; 
    	}
    }
    /**
     * get the speed
     * @return the speed
     */
    public int getSpeed() {
    	return this.speed;
    }
    /**
     * get the loader of the dungeon
     * @return dungeonLoader
     */
	public DungeonLoader getDungeonLoader() {
		return dungeonLoader;
	}
	
	/**
	 * pause the game
	 */
	public void pauseGame() {
		if(this.running == true) {
			this.running = false;
		}else {
			this.running = true; 
		}
	}

	/**
	 * set running
	 * @param run true or false
	 */
	public void setRunning(boolean run) {
		this.running = run; 
	}

	/**
	 * get the running status
	 * @return
	 */
	public boolean getRunning() {
		return this.running;
	}
	/**
	 * get the width of the dungeon
	 * @return width
	 */
	public int getWidth() {
        return width;
    }

	/**
	 * get the height of the dungeon
	 * @return height
	 */
    public int getHeight() {
        return height;
    }

    /**
     * get the player info
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * get the list of info of enemies
     * @return enemylist
     */
    public List<Enemy> getEnemies(){
    	return this.enemyList;
    }

    /**
     * get the list of info of animals
     * @return animallist
     */
    public List<Animal> getAnimals(){
    	return this.animalList;
    }
    /**
     * set the player
     * @param player the info of the player
     */
    public void setPlayer(Player player) {
        this.player = player;
        Thread playerthread = new Thread(player);
        playerthread.start();
        
    }
    
    /**
     * add animal to the list
     * @param a animal
     */
    public void addAnimal(Animal a) {
    	Thread animal = new Thread(a);
    	animalList.add(a);
    	observers.add(a);
    	animal.start();
    }
    
    /**
     * add entity to the entity list
     * @param entity the info of an entity
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    
    
    /**
     * add wall to list of walls
     * @param wall wall info
     */
    public void addWall(Wall wall) {
        walls.add(wall);
    }
    
    /**
     * remove the wall from the wall list
     * @param wall
     */
    public void reWall(Wall wall) {
    	walls.remove(wall);
    }
    
    /**
     * add Treasure to the treasure list
     * @param t treasure info
     */
    public void addTreasure(Treasure t) {
    	treasureList.add(t);
    }
    
    /**
     * remove the treasure from the treasure list
     * @param t the treasure
     */
    public void reTreasure(Treasure t) {
    	treasureList.remove(t);
    	//How to make the  	
    	  
    }
    
    /**
     * remove the enemy from the enemy list
     * @param e the enemy
     */
    public void rmEnemey(Enemy e) {
    	enemyList.remove(e);
    	observers.remove(e);
    }
    
    /**
     * remove the invincibility potion from the lidt
     * @param i the potion
     */
    public void rmInvincibilty(Invincibility i) {
    	invincibilityList.remove(i);
    }
    
    /**
     * remove the sword from the list
     * @param s the sword
     */
    public void rmSword(Sword s) {
    	swordList.remove(s);
    	
    }
    
    /**
     * remove the bomb from the bomb list
     * @param b the bomb
     */
    public void rmBomb(Bomb b) {
    	bombList.remove(b);
    	observers.remove(b);
    }
    
    /**
     * get the list of walls
     * @return
     */
    public List<Wall> getWall() {
		return walls;
    }
    
    /**
     * the function can identity if the given location of the entity is a wall
     * @param x the x
     * @param y the y
     * @return true (is wall) or false (is not wall)
     */
    public boolean isWall(int x, int y) {
    	int access = 0;
    	for(Wall w: walls) {
    		if(w.getX() == x && w.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    }
    
   
    /**
     * the function can identity if the given location of the entity is an enemy
     * @param x the x
     * @param y the y
     * @return true (is enemy) or false (is not enemy)
     */
    public boolean isEnemy(int x, int y) {
 
    	int access = 0;
    	for(Enemy e: enemyList) {
    		if(e.getX() == x && e.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * the function can identity if the given location of the entity is a treasure
     * @param x the x
     * @param y the y
     * @return true (is treasure) or false (is not treasure)
     */
    public boolean isTreasure(int x, int y) {
    	int access = 0;
    	for(Treasure t: treasureList) {
    		if(t.getX() == x && t.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    }

    /**
     * add a boulder to a list
     * @param boulder the boulder info
     */
    public void addBoulder(Boulder boulder) {
    	boulders.add(boulder);
    }
    
    /**
     * the function can identity if the given location of the entity is a boulder
     * @param x the x
     * @param y the y
     * @return true (is boulder) or false (is not boulder)
     */
    public boolean isBoulder(int x, int y) {
    	int access = 0;
    	for(int i = 0; i < boulders.size(); i++) {
    		if(boulders.get(i).getX() == x && boulders.get(i).getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
		return false;
    }
    
    /**
     * the function can identity if the given location of the entity is a bomb
     * @param x the x
     * @param y the y
     * @return true (is bomb) or false (is not bomb)
     */
    public boolean isBomb(int x, int y) {
    	int access = 0;
    	for(Bomb b: bombList){
    		if(b.getX() == x && b.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    	
    }
    
    /**
     * the function can identity if the given location of the entity is a sword
     * @param x the x
     * @param y the y
     * @return true (is sword) or false (is not sword)
     */
    public boolean isSword(int x, int y) {
      	int access = 0;
    	for(Sword s: swordList){
    		if(s.getX() == x && s.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * the function can identity if the given location of the entity is an invincible potion
     * @param x the x
     * @param y the y
     * @return true (is potion) or false (is not potion)
     */
    public boolean isInvincibility(int x, int y ) {

      	int access = 0;
    	for(Invincibility i: invincibilityList){
    		if(i.getX() == x && i.getY() == y) {
    			access = 1;
    		}
    	}
    	if(access == 1) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * add the potion to the potion list
     * @param i the invincible potion
     */
    public void addInvincy(Invincibility i) {
    	
    	invincibilityList.add(i);
    }
    
    /**
     * add bomb to the bomb list
     * @param b the bomb
     */
    public void addBomb(Bomb b) {
    	bombList.add(b);
    	observers.add(b);
    }
    
    /**
     * set the boulder to a new position
     * @param x the x
     * @param y the y
     * @param newX the new x
     * @param newY the new y
     */
    public void setBoulder(int x, int y, int newX, int newY) {
    	for(int i = 0; i < boulders.size(); i++) {
    		if(boulders.get(i).getX() == x && boulders.get(i).getY() == y) {
    			if(!isWall(newX, newY) && !isBoulder(newX, newY)) {
    				boulders.get(i).x().set(newX);
	    			boulders.get(i).y().set(newY);	    			
	    			break;
    			}
    		}
    	}
    }
    
    /**
     * get the treasure list
     * @return the treasure list
     */
    public List<Treasure> getTreasureList(){
    	return this.treasureList;
    }
    
    /**
     * get the invincible potion list
     * @return the potion list
     */
    public List<Invincibility> getInviList(){
    	return this.invincibilityList;
    }
    
    /**
     * get the sword list
     * @return the sword list
     */
    public List<Sword> getSwordList(){
    	return this.swordList;
    }
    
    /**
     * get the bomb list
     * @return the bomb list
     */
    public List<Bomb> getBombList(){
    	return this.bombList;
    }
 
    /**
     * get the switch list
     * @return the switch list
     */
    public void addSwitch (Switch s) {
    	ss.add(s);
    }
    
    /**
     * add enemy to the list
     * @param e enemy
     */
    public void addEnemy (Enemy e) {
    	Thread enemy = new Thread(e);
//    	enemyThreadList.add(enemy);
    	enemyList.add(e);
    	observers.add(e);
    	enemy.start();
    }
    
    /**
     * add sword to the list
     * @param s sword
     */
    public void addSword(Sword s) {
    	swordList.add(s);
    }
    
    /**
     * check all the switch
     * @return true or false
     */
    public boolean checkSwitch () {
    	int number = 0;
    	for (Switch s: ss) {
    		for (Boulder b: boulders) {
    			if(s.getX() == b.getX() && s.getY() == b.getY()) {
    				number++;
    			}
    		}
    	}
    	if(number == ss.size()) {
    		return true;
    	}
		return false;
    }
    
    /**
     * set the goal for the game
     * @param goal
     */
    public void setGoal(String goal) {
    	goals.add(goal);
    }
    /**
     * get the goals
     * @return goal list
     */
    public List<String> getGoal() {
    	return goals;
    }

    /**
     * get the exit info
     * @return exit
     */
	public Exit getExit() {
		return exit;
	}

	/**
	 * set the info of the exit
	 * @param exit the exit
	 */
	public void setExit(Exit exit) {
		this.exit = exit;
	}
    
	/**
	 * attach the observer
	 */
	@Override 
	public void Attach(PlayerObserver o) {
		// TODO Auto-generated method stub
		this.observers.add(o);
		
	}

	/**
	 * deattach the observer
	 */
	@Override
	public void Deattach(PlayerObserver o) {
		// TODO Auto-generated method stub
		this.observers.remove(o);
		
	}

	/**
	 * notify entities
	 */
	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		for(PlayerObserver o: observers) {
			o.alarm(this.player.getStatus());
		}
	}	
	
}
