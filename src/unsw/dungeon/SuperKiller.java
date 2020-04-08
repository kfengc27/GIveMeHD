package unsw.dungeon;

public class SuperKiller extends Decortor{
	
	private int blood = 3;
	
	private Killer killer = null;
	
	public SuperKiller(Killer killer) {
		this.killer = killer; 
	}
	
	public int getBlood(){
		return blood;
	}

}
