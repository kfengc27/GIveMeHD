package unsw.dungeon;

/**
 * a class that stores info of bomb entity
 * @author Chengbin
 *
 */
public class Bomb extends Entity implements Arm, PlayerObserver, Property{
	
	private boolean useless;
	private Dungeon dungeon;
	private boolean afriad;
	private int bombX; 
	private int bombY; 
	private Thread t;

	/**
	 * constructor
	 * @param dungeon the dungeon
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Bomb(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.afriad = false; 
		this.bombX = -1; 
		this.bombY = -1; 
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the name of the entity
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bomb";
	}
	
	/**
	 * update the state
	 * @param playerstate true or false
	 */
	public void update(boolean playerstate) {
		// TODO Auto-generated method stub
		//if the player is invincible 
		if(playerstate == true) {
			this.useless = true;
		}else {
			this.useless = false; 
		}
	}

	/**
	 * tell the enemies the player is invincible
	 */
	@Override
	public void alarm(boolean state) {
		// TODO Auto-generated method stub
		System.out.println("Hello bomb, The player is" + state);
		if(state == true) {
			this.afriad = true;
		}else {
			this.afriad = false; 
		}
	}

	/**
	 * operate the bomb
	 */
	@Override
	public void operate(int x, int y) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		this.bombX = x; 
		this.bombY = y; 
	
		t = new Thread(new bombInner()); 
		t.start();
		
		this.dungeon.addBomb(this);
		this.dungeon.getDungeonLoader().onLoad(this);
		System.out.println("The bomb is here");
		
	}
	
	
	public void bombKill(int x, int y){
		int minX = x - 1;
		int maxX = x + 1;
		int minY = y - 1; 
		int maxY = y + 1; 
		//boolean bomb = this.afriad; 
		boolean bomb = this.dungeon.getPlayer().getStatus(); 
		try {
		if((this.dungeon.getPlayer().getX()>=minX)&&(this.dungeon.getPlayer().getX()<=maxX)&&(this.dungeon.getPlayer().getY()>=minY)&&(this.dungeon.getPlayer().getY()<=maxY)) { 
			if(!bomb) {
				this.dungeon.killPlayer();
			}else {
				System.out.print("THe plater is alive.");
			}
		}
		
		for(Enemy e: this.dungeon.getEnemies()) {
			if((e.getX()>=minX)&&(e.getX()<=maxX)&&(e.getY()>=minY)&&(e.getY()<=maxY)) {
				//the enemy die 
				this.dungeon.getEnemies().remove(e);
				this.dungeon.getDungeonLoader().deleteEnemies(e);
			}
		}
		
		}catch(Exception e) {
			
		}
	}

	
	/**
	 * return the arm type
	 */
	@Override 
	public String armtype() {
		return "bomb";
	}
	
	private class bombInner implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(5000);
				System.out.println("The player will slepp for a long time");
				Bomb b = new Bomb(Bomb.this.dungeon, Bomb.this.bombX, Bomb.this.bombY); 
//				Bomb.this.dungeon.getDungeonLoader().onLoadLightingS1(b);
//				Bomb.this.dungeon.getDungeonLoader().onLoadLightingS2(b);
//				Bomb.this.dungeon.getDungeonLoader().onLoadLightingS3(b);
//				Bomb.this.dungeon.getDungeonLoader().onLoadLightingS4(b);
				Bomb.this.bombKill(bombX, bombY);
				System.out.println("It starts to work");
			}catch(Exception e) {
				
			}
		}
		
	}
	
}
