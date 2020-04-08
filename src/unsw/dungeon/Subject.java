package unsw.dungeon;

/**
 * the subject interface
 * @author Chengbin
 *
 */
public interface Subject {
	
	void Attach(PlayerObserver o);
	void Deattach(PlayerObserver o);
	void Notify();
//	void Attach(java.util.Observer o);

}

