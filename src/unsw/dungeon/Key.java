package unsw.dungeon;

/**
 * the class that holds info for key
 * @author Chengbin
 *
 */
public class Key extends Entity implements Arm, Property{

	public Key(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operate(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String armtype() {
		// TODO Auto-generated method stub
		return "key";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Key";
	}
	
}
