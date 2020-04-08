package unsw.dungeon;
/**
 * A class that holds info of sword
 * @author Chengbin
 *
 */
public class Sword extends Entity implements Arm, Property{
	
	private int maxKill = 5;
	private Dungeon dungeon;

	/**
	 * constructor
	 * @param dungeon the dungeon
	 * @param x the x coordinator
	 * @param y the y coordinator
	 */
	public Sword(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon; 
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the name
	 */
	public String getName(){
		return "Sword";
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
	 * get maxkill
	 * @return
	 */
	public int getMaxKill() {
		return maxKill;
	}
	
	public void kill(Enemy e, Dungeon d) {
		
	}
	
	public boolean isAble() {
		if(maxKill > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void operate(int x, int y) {
		if(isAble()) {
			this.maxKill --;
			System.out.println("The enemies are " + this.dungeon.getEnemies() + " number");
			for(Enemy e: this.dungeon.getEnemies()) {
				if((e.getX() == x)&&(e.getY() ==  y)) {
					System.out.println("The enemy in "  + x + " " + y + " die.");
					e.beKilled();
					System.out.println("The enemy is being " + e.getStop() + " killed");
					this.dungeon.getEnemies().remove(e);
					//remove enemy from above list 
					this.dungeon.getDungeonLoader().deleteEnemies(e);
					break;
				}				
			}
			for(Animal a: this.dungeon.getAnimals()) {
				if((a.getX() == x)&&(a.getY() ==  y)) {
					System.out.println("The enemy in "  + x + " " + y + " die.");
					this.dungeon.getAnimals().remove(a);
					a.beKilled();
					System.out.println("The animal is being " + a.getStop() + " killed");
					//remove enemy from above list 
					this.dungeon.getDungeonLoader().deleteAnimals(a);;
					break;
				}				
			}
		}else {
			System.out.println("This sword has be used 5 times.\n");
			System.out.println("You should press SHIFT to release the current sword and use a new sword if you have picked more than one sword.");
			
		}
		
		// TODO Auto-generated method stub
	}
	
	@Override 
	public String armtype() {
		return "sword";
	}
	
	
}
