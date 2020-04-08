package unsw.dungeon;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * The player entity
 * @author Robert Clifton-Everest, modified by Junhui and Chengbin
 *
 */
public class Player extends Entity implements Runnable{

    private Dungeon dungeon;
    private PropertyDirectory backpack;
    private boolean invincible; 
    private double money; 
    private Arm arm; 
    private ArrayList<Arm> armList = new ArrayList<Arm>();
	private Boolean success = false;   
   
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.backpack = new PropertyDirectory();
        this.invincible = false;  
        this.money = 0; 
        this.arm = null; 
        this.armList = new ArrayList<>(); 
   
    }
    
    /**
     * set the status of if success
     * @param success
     */
    public void setSuccess(Boolean success) {
    	this.success = success;
    }
    
    /**
     * get the status of whether succeeded
     * @return
     */
    public boolean getSuccess() {
    	return success;
    }
    
    /**
     * get the entity name
     * @return
     */
    public String getName() {
    	return "Hero Player";
    }
    
    /**
     * let the player be invincible
     */
    public void beInvincible() {
    	this.invincible = true;
    	this.dungeon.Notify();
    }
    
    /**
     * if the player is normal, aka not invincible
     */
    public void beNormal() {
    	this.invincible = false;
    	this.dungeon.Notify();
    }
    
    /**
     * get the status of the player
     * @return true or false
     */
    public boolean getStatus() {
    	return invincible;
    }
    
    /**
     * kill the enemy if the enemy is right above you
     */
    public void killUp() {
    
    	try {
    		System.out.println("The player is try to Kill Up");
	    	if(arm.armtype().equals("sword")) {
	    		System.out.println("Let's kill");
	    		this.arm.operate(this.getX(), this.getY()-1);
	    	}else {
	    		//do nothing 
	    	}
    	}catch(NullPointerException e){
    		 
    	}
    }
    /**
     * kill the enemy if the enemy is right on the left from you
     */
    public void killLeft() {
    	
    	try {
    		System.out.println("The player is try to Kill Left");
    	if(arm.armtype().equals("sword")) {
    		System.out.println("Let's kill");
    		this.arm.operate(this.getX()-1, this.getY());
    	}else {
    		//do nothing 
    	}}catch(NullPointerException e){
    		
    	}
    }
    /**
     * kill the enemy if the enemy is right on the right from you
     */
    public void killRight() {
    
    	try {
    		System.out.println("The player is try to Kill Right");
    	if(arm.armtype().equals("sword")) {
    		System.out.println("Let's kill");
    		this.arm.operate(this.getX()+1, this.getY());
    	}else {
    		//do nothing 
    	}}catch(NullPointerException e){
    		
    	}
    }
    
    /**
     * kill the enemy if the enemy is right below you
     */
    public void killDown() {

    	try {
    		System.out.println("The player is try to Kill Down");
	    	if(arm.armtype().equals("sword")) {
	    		System.out.println("Let's kill");
	    		this.arm.operate(this.getX(), this.getY()+1);
    	}else {
    		//do nothing 
    	}}catch(NullPointerException e){
    		
    	}
    }
    
    /**
     * release the arm
     */
	public void releaseArms() {
		// TODO Auto-generated method stub
		this.arm = null; 
		System.out.println("The player is holding nothing.");
	}
	
	/**
	 * show player status by printing
	 */
	public void showPlayerStatue() {
		try {
			System.out.println("The player is holding " + this.arm.armtype() + " with " + this.money + " money " + " and is " + this.getStatus() + " invincible!");
		}catch(NullPointerException e) {
			System.out.println("The player is holding nothing "  + "with " + this.money + " money " + " and is " + this.getStatus() + " invincible!");
		}
	}
	
	/**
	 * change weapon to sword
	 */
	public void changeToSword() {
		for(Arm a: armList) {
			if(a.armtype().equals("sword")) {
				this.arm = a;
				System.out.println("The player is holding a sword");
			}
		}		
	}
	
	/**
	 * change weapon to bomb
	 */
	public void changeToBomb(){
		for(Arm a: armList) {
			if(a.armtype().equals("bomb")) {
				this.arm = a;
				System.out.println("The player is holding a bomb");
			}
		}		
	}
	
	
	/**
	 * light the bomb
	 */
	public void lightBomb(){
		System.out.println("I will light the bomb");
		if(this.arm.armtype().equals("bomb")) {
			
			Bomb b = new Bomb(this.dungeon, this.getX(), this.getY());
			this.dungeon.addBomb(b);
			this.dungeon.getDungeonLoader().onLoad(b);
			//load bomb 
			this.dungeon.addEntity(b);
			this.arm.operate(this.getX(), this.getY());
		}
		
	}
    
	/**
	 * get the treasure
	 * @return
	 */
    public double getMoney() {
    	for(Property p: backpack.getProperties()) {
    		if(p.getName().equals("Treasure")) {
    			this.money += 100;
    			System.out.println("I have " + this.money);
    		}
    	}
    	return this.money;
    }
    
    /**
     * true if success
     * @return
     */
    public boolean Success() {
    	if(dungeon.getGoal().get(0).equals("exit")) {
    		dungeon.getExit();
    		if(dungeon.getExit().getX() == getX() && dungeon.getExit().getY() == getY()) {
    			return true;
    		}
    	} else if (dungeon.getGoal().get(0).equals("boulders")) {
    		//System.out.println(dungeon.checkSwitch());
    		return dungeon.checkSwitch();
    		
    	} else {
    		if(dungeon.getTreasureList().isEmpty() && dungeon.getEnemies().isEmpty()) {
    			System.out.println(dungeon.getGoal());
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * add property
     * @param p property
     */
    public void addProperty(Property p) {
    	backpack.addProperty(p);
    }
    
    /**
     * remove property
     * @param p
     */
    public void removeProperty(Property p) {
    	
    }
    
    /**
     * player moves up
     */
    public void moveUp() {
    	if(this.dungeon.getRunning()==false) {
    		//do nothing  
    	}else {
	        if (getY() > 0) {
	        	//System.out.println(dungeon.getPlayer().getX());
	        	if(dungeon.isWall(getX(), getY()-1)) {
	        		y().set(getY());
	        	}else if(dungeon.isTreasure(getX(), getY()-1)){
	        		/*
	        		 * if this is treasure.
	        		 */
	        		y().set(getY()-1);
	        		Treasure t = pickTreasure(this.getX(), this.getY());
	        		System.out.println("The treasure is " + t.getName() + " Location X is " + t.getX() + " Y is " + t.getY());
	        		backpack.addProperty(t);
	        		System.out.println(Success());
	        		
	        	}else if(dungeon.isInvincibility(getX(), getY()-1)) {
	        		
	        		y().set(getY()-1);
	        		Invincibility i = pickInvincibility(this.getX(), this.getY());
	        		backpack.addProperty(i);
	        		Thread ivThread = new Thread(i);
	        		ivThread.start();
	        	}else if(dungeon.isBomb(getX(), getY()-1)) {
	        		y().set(getY()-1);
	        		Bomb b = pickBomb(this.getX(), this.getY());
	        		armList.add(b);
	        		backpack.addProperty(b);
	        	}else if(dungeon.isSword(getX(), getY()-1)) {
	        		y().set(getY()-1);
	        		Sword s = pickSword(this.getX(), this.getY());
	        		armList.add(s);
	        		backpack.addProperty(s);
	        	}else if(dungeon.isEnemy(getX(), getY()-1)) {
	        		y().set(getY());
	        		
	        	}
	        	else {
	        		if(getY() > 1 && ((dungeon.isBoulder(getX(), getY()-1) 
	                				&& dungeon.isWall(getX(), getY()-2))|| (dungeon.isBoulder(getX(), getY()-1) 
	                                		&& dungeon.isBoulder(getX(), getY()-2)))){    
	        			y().set(getY());
	        		} else {
	        			y().set(getY() - 1);
	        			if(dungeon.isBoulder(getX(), getY())) {
	        				dungeon.setBoulder(getX(), getY(), getX(), getY()-1);
	        			}
	        		}
	        		
	
	        		//System.out.println(Success());
	
	        		//System.out.println(dungeon.isBoulder(getX(), getY()));
	        		//System.out.println(Success());
	
	        	}
	        }
        }
        setSuccess(Success());
//        this.backpack.upDateLocation(this.getX(), this.getY());
    } 
    
    /**
     * player moves down
     */
	public void moveDown() {
		if(this.dungeon.getRunning()==false) {
    		
    	}else {
        if (getY() < dungeon.getHeight() - 1) {
        	if(dungeon.isWall(getX(), getY()+1)) {
        		y().set(getY());
        	}else if(dungeon.isTreasure(getX(), getY()+1)){
        		/*
        		 * if this is treasure.
        		 */
        		y().set(getY()+1);
        		Treasure t = pickTreasure(this.getX(), this.getY());
        		System.out.println("The treasure is " + t.getName() + " Location X is " + t.getX() + " Y is " + t.getY());
        		backpack.addProperty(t);
        		this.getMoney();
        		System.out.println(Success());
        		
        	}else if(dungeon.isBomb(getX(), getY()+1)) {
        		y().set(getY()+1);
        		Bomb b = pickBomb(this.getX(), this.getY());
        		armList.add(b);
        		backpack.addProperty(b);
        	}else if(dungeon.isSword(getX(), getY()+1)) {
        		y().set(getY()+1);
        		Sword s = pickSword(this.getX(), this.getY());
        		armList.add(s);
        		backpack.addProperty(s);
        	}else if(dungeon.isInvincibility(getX(), getY()+1)) {
        		
        		y().set(getY()+1);
        		Invincibility i = pickInvincibility(this.getX(), this.getY());
        		backpack.addProperty(i);
        		Thread ivThread = new Thread(i);
        		ivThread.start();
        	}
        	else if(dungeon.isEnemy(getX(), getY()+1)) {
        		y().set(getY());
        	} 
        	else {      
        		if(getY() < dungeon.getHeight() - 2 && ((dungeon.isBoulder(getX(), getY()+1) 
                				&& dungeon.isWall(getX(), getY()+2))|| (dungeon.isBoulder(getX(), getY()+1) 
                                		&& dungeon.isBoulder(getX(), getY()+2)))){ 

        			y().set(getY());
        			//y().set(getY());		
        		} else {
        			y().set(getY() + 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX(), getY()+1);
        			}
        			//System.out.println(Success());
        		}
        		//y().set(getY() + 1);
        	}            
        }
        }
        setSuccess(Success());
    }

	/**
	 * player moves left
	 */
    public void moveLeft() {
    	if(this.dungeon.getRunning()==false) {
    		
    	}else {
        if (getX() > 0) {
        	if(dungeon.isWall(getX()-1, getY())) {
        		x().set(getX());
        	}else if(dungeon.isTreasure(getX()-1, getY())){
        		/*
        		 * if this is treasure.
        		 */
        
        		x().set(getX()-1);
        		Treasure t = pickTreasure(this.getX(), this.getY());
        		System.out.println("The treasure is " + t.getName() + " Location X is " + t.getX() + " Y is " + t.getY());
        		backpack.addProperty(t);
        		System.out.println(Success());
        		
        	}else if(dungeon.isSword(getX()-1, getY())) {
        		x().set(getX()-1);
        		Sword s = pickSword(this.getX(), this.getY());
        		armList.add(s);
        		backpack.addProperty(s);
        	}else if(dungeon.isBomb(getX()-1, getY())) {
        		x().set(getX()-1);
        		Bomb b = pickBomb(this.getX(), this.getY());
        		armList.add(b);
        		backpack.addProperty(b);
        	}else if(dungeon.isInvincibility(getX()-1, getY())) {
        		
        		x().set(getX()-1);
        		Invincibility i = pickInvincibility(this.getX(), this.getY());
        		backpack.addProperty(i);
        		Thread ivThread = new Thread(i);
        		ivThread.start();
        	}
        	else if(dungeon.isEnemy(getX()-1, getY())) {
        		x().set(getX());
        		
        	} else {
        		if(getX() > 1 && ((dungeon.isBoulder(getX()-1, getY()) 
                				&& dungeon.isWall(getX()-2, getY()))|| (dungeon.isBoulder(getX()-1, getY()) 
                        		&& dungeon.isBoulder(getX()-2, getY())))){ 
        		
        			x().set(getX());	
        		}else if(dungeon.isEnemy(getX()-1, getY())) {
            		x().set(getX());
            	} 
        		else {
        			x().set(getX() - 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX()-1, getY());
        			}
        			//System.out.println(Success());
        		}
        		//x().set(getX() - 1);
        		//System.out.println(Success());
        	}            
        	}
        }
        setSuccess(Success());
    }

    /**
     * player moves right
     */
    public void moveRight() {
    	if(this.dungeon.getRunning()==false) {
    		
    	}else {
        if (getX() < dungeon.getWidth() - 1) {
        	if(dungeon.isWall(getX()+1, getY())) {
        		x().set(getX());
        	}else if(dungeon.isTreasure(getX()+1, getY())) {
        		x().set(getX()+1);
        		Treasure t = pickTreasure(this.getX(), this.getY());
        		System.out.println("The treasure is " + t.getName() + " Location X is " + t.getX() + " Y is " + t.getY());
        		backpack.addProperty(t);
        		System.out.println(Success());
        	} else if(dungeon.isSword(getX()+1, getY())) {
        		x().set(getX()+1);
        		Sword s = pickSword(this.getX(), this.getY());
        		armList.add(s);
        		backpack.addProperty(s);
        	}else if(dungeon.isBomb(getX()+1, getY())) {
        		x().set(getX()+1);
        		
        		Bomb b = pickBomb(this.getX(), this.getY());
        		armList.add(b);
        		backpack.addProperty(b);
        	}else if(dungeon.isInvincibility(getX()+1, getY())) {
        		x().set(getX()+1);
        		Invincibility i = pickInvincibility(this.getX(), this.getY());
        		backpack.addProperty(i);
        		Thread ivThread = new Thread(i);
        		ivThread.start();
        	}else if(dungeon.isEnemy(getX()+1, getY())) {
        		x().set(getX());
        	} else {
        		if(getX() < dungeon.getWidth() - 2 && ((dungeon.isBoulder(getX()+1, getY()) 
        				&& dungeon.isWall(getX()+2, getY()))|| (dungeon.isBoulder(getX()+1, getY()) 
        				&& dungeon.isBoulder(getX()+2, getY())))){  	
        			x().set(getX());	
        		} else {
        			x().set(getX() + 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX()+1, getY());
        			}
        			//System.out.println(Success());
        		}
        	}            
        }
        }
        setSuccess(Success());
    }
    
    
    
    /**
     * pick up treasure
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the treasure
     */
    public Treasure pickTreasure(int x, int y) {
	   	for(Treasure t: dungeon.getTreasureList() ) {
	   		if(t.getX() == x && t.getY() == y) {
	   			System.out.println("----");
	   				dungeon.reTreasure(t);
	   				dungeon.getDungeonLoader().deleteTreasure(t);
	    			return t; 
	    			
	    	}
	   	}
		return null;
    }
    
    /**
     * pick up potion
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the potion
     */
    public Invincibility pickInvincibility(int x, int y) {
    	for(Invincibility i: dungeon.getInviList()) {
    		
    		if(i.getX() == x && i.getY() == y) {
    			dungeon.rmInvincibilty(i);
    			dungeon.getDungeonLoader().deleteInvincibility(i);
    			return i;
    		}
    	}
		return null;
    }
    
    /**
     * pick up sword
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the sword
     */
    public Sword pickSword(int x, int y) {
    	for(Sword s: dungeon.getSwordList()) {
    		if(s.getX() == x && s.getY() == y) {
    			dungeon.rmSword(s);
    			dungeon.getDungeonLoader().deleteSword(s);
    			return s;
    		}
    	}
		return null;
    }
    /**
     * pick up bomb
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the bomb
     */
    public Bomb pickBomb(int x, int y) {
    	for(Bomb b: dungeon.getBombList()){
    		if(b.getX() == x && b.getY() == y) {
    			dungeon.rmBomb(b);
    			dungeon.getDungeonLoader().deleteBomb(b);
    			return b;
    		}
    	}
		return null;
   	}

   
    
    /**
     * thread runnable
     */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{while(true) {
			if(dungeon.getPlayer()!=null) {
				Thread.sleep(2000);
				if(this.dungeon.getPlayer()!=null) {
					if(!backpack.getProperties().isEmpty()) {
						for(Property p: backpack.getProperties()) {
							System.out.println("I have " + p.getName() + " ");
						}
					}
				}else {
					System.out.println("The player has died. Game Over! T T");
					break;
				}
			}else {
				System.out.println("The player is died.");
			}
			}
		}catch(Exception e) {
			
		}
	}


	
 
}
    
   