package unsw.dungeon;

/**
 * the class that holds info of invincibility potion
 * @author Chengbin
 *
 */
public class Invincibility extends Entity implements Property, Runnable{
	
	private Dungeon dungeon;
	
	/**
	 * constructor
	 * @param dungeon the dungeon
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Invincibility(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the name of the entity
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Invincibility potion";
	}
	

	/**
	 * update the location
	 */
	@Override
	public void upDateLocation(int x, int y) {
		// TODO Auto-generated method stub
		this.x().set(x);
		this.y().set(y);
	}

	/**
	 * thread runnable
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			dungeon.getPlayer().beInvincible();
			System.out.println("Playe is " + dungeon.getPlayer().getStatus() +" invible now");
		
			Thread.sleep(10000);
//			System.out.println("I have spledhrkhahjh");
//			dungeon.getInviList().remove(0);
			dungeon.getPlayer().beNormal();
			System.out.println("Playe is " + dungeon.getPlayer().getStatus() +" invible now");
		}catch(Exception e) {
			
		}
		
	}


}
