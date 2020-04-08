package unsw.dungeon;

public class MiddleKiller extends Decortor{
	
	private int blood = 2;
	
	private Killer killer = null;
	
	public MiddleKiller(Killer killer) {
		this.killer = killer; 
	}
	
	public int getBlood(){
		return blood;
	}
	
}
