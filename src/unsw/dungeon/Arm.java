package unsw.dungeon;

/**
 * An interface for arms: sword and bomb
 * @author Chengbin
 *
 */
public interface Arm {

	public void operate(int x, int y);
	public String armtype();
	
}
