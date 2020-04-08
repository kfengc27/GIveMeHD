package unsw.dungeon;
/**
 * a class that holds info of treasures
 * @author Chengbin
 *
 */
public class Treasure extends Entity implements Property{

	public Treasure(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public String getName(){
		return "Treasure";
	}

	@Override
	public void upDateLocation(int x, int y) {
		// TODO Auto-generated method stub
		this.x().set(x);
		this.y().set(y);
	}

	
}
