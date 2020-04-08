package unsw.dungeon;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * property directory class
 * @author Chengbin
 *
 */
public class PropertyDirectory implements Property{

	ArrayList<Property> propertyList = new ArrayList<Property>();

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * add property
	 * @param p property
	 */
	public void addProperty(Property p) {
		System.out.println("The backpage is "+this.propertyList.size());
		this.propertyList.add(p);
		System.out.println("Success picked");
		System.out.println("The backpage is "+this.propertyList.size());
	}
	
	/**
	 * remove the property
	 * @param p property
	 */
	public void removeProperty(Property p) {
		this.propertyList.remove(p);
	}
	
	/**
	 * get properties
	 * @return property list
	 */
	public ArrayList<Property> getProperties() {
		return this.propertyList;
	}

	@Override
	public void upDateLocation(int x, int y) {
		// TODO Auto-generated method stub
		
	}
		
}
