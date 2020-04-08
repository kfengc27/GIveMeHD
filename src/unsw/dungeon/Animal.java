package unsw.dungeon;

import java.util.ArrayList;


public class Animal extends Entity implements PlayerObserver, Killer, Runnable{

/**
 * a class that stores info of the animal entity
 * @author Chengbin
 *
 */

    private Dungeon dungeon;
    private Player player; 
    private boolean afriad; 
    private boolean stop;
  
    /**
     * Create a player positioned in square (x,y)
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Animal(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.afriad = false;
    }
    

    /**
     * animal move up
     */
    public void moveUp() {
        if (getY() > 0) {
        	//System.out.println(dungeon.getPlayer().getX());
        	if(dungeon.isWall(getX(), getY()-1)) {
        		y().set(getY());
        	} else {
        		if(getY() > 1 && ((dungeon.isBoulder(getX(), getY()-1) 
                				&& dungeon.isWall(getX(), getY()-2))|| (dungeon.isBoulder(getX(), getY()-1) 
                                		&& dungeon.isBoulder(getX(), getY()-2)))){    
        			y().set(getY());
        		} else {
        			y().set(getY() - 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX(), getY()-1);
        			}
        		}
        		
        		//System.out.println(dungeon.isBoulder(getX(), getY()));
        	}
        }
    }   
    /**
     * animal move down
     */
	public void moveDown() {
        if (getY() < dungeon.getHeight() - 1) {
        	if(dungeon.isWall(getX(), getY()+1)) {
        		y().set(getY());
        	} else {      
        		if(getY() < dungeon.getHeight() - 2 && ((dungeon.isBoulder(getX(), getY()+1) 
                				&& dungeon.isWall(getX(), getY()+2))|| (dungeon.isBoulder(getX(), getY()+1) 
                                		&& dungeon.isBoulder(getX(), getY()+2)))){ 

        			y().set(getY());
        			//y().set(getY());		
        		} else {
        			y().set(getY() + 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX(), getY()+1);
        			}
        		}
        		//y().set(getY() + 1);
        	}            
        }
    }

	/**
	 * animal move left
	 */
    public void moveLeft() {
        if (getX() > 0) {
        	if(dungeon.isWall(getX()-1, getY())) {
        		x().set(getX());
        	} else {
        		if(getX() > 1 && ((dungeon.isBoulder(getX()-1, getY()) 
                				&& dungeon.isWall(getX()-2, getY()))|| (dungeon.isBoulder(getX()-1, getY()) 
                        		&& dungeon.isBoulder(getX()-2, getY())))){ 
        		
        			x().set(getX());	
        		} else {
        			x().set(getX() - 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX()-1, getY());
        			}
        		}
        		//x().set(getX() - 1);
        		//System.out.println(Success());
        	}            
        }
    }

    /**
     * animal move right
     */
    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1) {
        	if(dungeon.isWall(getX()+1, getY())) {
        		x().set(getX());
        	} else {
        		if(getX() < dungeon.getWidth() - 2 && ((dungeon.isBoulder(getX()+1, getY()) 
        				&& dungeon.isWall(getX()+2, getY()))|| (dungeon.isBoulder(getX()+1, getY()) 
        				&& dungeon.isBoulder(getX()+2, getY())))){  
        			
        			x().set(getX());	
        		} else {
        			x().set(getX() + 1);
        			if(dungeon.isBoulder(getX(), getY())) {
        				dungeon.setBoulder(getX(), getY(), getX()+1, getY());
        			}
        		}
        		//x().set(getX() + 1);
        		//System.out.println(Success());
        	}            
        }
    }
    
   /**
    * Player will die if he is not invincible after being attacked by enemy;
    * @param x the x coordinate
    * @param y the y coordinate
    */
   public void killPlayer(int x, int y) {
	   if((this.getX() == x)&&(this.getY() == y) &&(!this.afriad)) {
		   System.out.println("The player is died.");
		   this.dungeon.killPlayer();
	   }
   }
   
   /**
    * the animal is killed
    */
   public void beKilled() {
	   this.stop = true; 
   }
   
   /**
    * tell the thread to stop
    * @return
    */
   public boolean getStop() {
	   return this.stop;
   }


   /**
    * thread runnable
    */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!stop) {
				
				if(this.dungeon.getRunning()==true) {
//				this.killPlayer();
				Thread.sleep(dungeon.getSpeed());
				if(this.stop == true) {
					System.out.println("break out of loop");
					break;
				}
				int X = dungeon.getPlayer().getX(); //the player X
				int Y = dungeon.getPlayer().getY(); //the player Y 
				int distanceX =  Math.abs(X - this.getX());
				int distanceY =  Math.abs(Y - this.getY());
				double G = 1;  //cost to next stop 
				double inValid = 999;
//				int H = Math.abs(X - this.getX()) + Math.abs(Y - this.getY()); // h is the heuristic of destination.
//				double H =  Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY, 2));
//				int F = H + G;
				ArrayList<Double> fList = new ArrayList<Double>(); 
				//left is not wall and try to move left
			    //Move Left 
				boolean left = dungeon.isWall(this.getX()-1, this.getY());
				boolean right = dungeon.isWall(this.getX()+1, this.getY());
				boolean up = dungeon.isWall(this.getX(),this.getY()-1);
				boolean down = dungeon.isWall(this.getX(), this.getY()+1);
				if(!left){
					System.out.println("Left is not wall");
					int distanceX1 = Math.abs(X - (this.getX()-1));
					int distanceY1 = Math.abs(Y - this.getY());
					double H1 = Math.sqrt( Math.pow(distanceX1,2) + Math.pow(distanceY1, 2));
					double F1 = H1*0.8 + G; 
					fList.add(F1);
				}else {
					fList.add(inValid);
				}
				//Move Right 
				if(!right){
					System.out.println("right is not wall");
					int distanceX2 = Math.abs(X - (this.getX()+1));
					int distanceY2 = Math.abs(Y- this.getY());
					double H2 = Math.sqrt( Math.pow(distanceX2,2) + Math.pow(distanceY2, 2));
					double F2 = H2*0.8 + G;
					fList.add(F2);
				}else {
					fList.add(inValid);
				}
				
				//Move Up 
				if(!up){
					System.out.println("up is not wall");
					int distanceX3 = Math.abs(X -  this.getX());
					int distanceY3 = Math.abs(Y - (this.getY()-1));
					double H3 = Math.sqrt( Math.pow(distanceX3,2) + Math.pow(distanceY3, 2));
					double F3 = H3*0.8 + G;
					fList.add(F3);
				}else {
					fList.add(inValid);
				}
				
				//Move Down 
				if(!down){
					System.out.println("down is not wall");
					int distanceX4 = Math.abs(X - this.getX());
					int distanceY4 = Math.abs(Y - (this.getY()+1));
					double H4 = Math.sqrt( Math.pow(distanceX4,2) + Math.pow(distanceY4, 2));
					double F4 = H4*0.8 + G; 
					fList.add(F4);
				}else{
					fList.add(inValid);
				}
				
				int minIndex = 0; 
				double min = inValid;
				for(int i=0; i< fList.size(); i++) {
					System.out.println("THe distance is :" +fList.get(i) + "\n");
					if(fList.get(i) < min) {
						min = fList.get(i);
						minIndex = i;
					}
			
				}
				
				int maxIndex = 0; 
				double max = 0 ; 
				for(int i = 0; i < fList.size(); i++) {
					if((fList.get(i)>max)&&(fList.get(i)<inValid)) {
						max = fList.get(i);
						maxIndex = i;
						
					}
				}
				
				System.out.println("the best move should be " + minIndex + " and distance is" + min + "\n" );
				if(this.afriad != true) {
					if(minIndex == 0) {
						this.moveLeft();
//						System.out.println("the player should move left");
					}else if(minIndex == 1){
						this.moveRight();
//						System.out.println("the player should move left");
					}else if(minIndex == 2) {
						this.moveUp();
//						System.out.println("the player should move Down");
					}else if(minIndex == 3) {
						this.moveDown();
//						System.out.println("the player should move Up");
					}
					this.killPlayer(X, Y);
				}else {
					if(maxIndex == 0) {
						this.moveLeft();
//						System.out.println("the player should move left");
					}else if(maxIndex == 1){
						this.moveRight();
//						System.out.println("the player should move left");
					}else if(maxIndex == 2) {
						this.moveUp();
//						System.out.println("the player should move Down");
					}else if(maxIndex == 3) {
						this.moveDown();
//						System.out.println("the player should move Up");
					}
				}

			}else {
				System.out.println("The game is stopped. The animal can not move");
			}
			}
		}catch(Exception e) {
			
		}
		
	}

	

	/**
	 * tell the entity the player is invincible
	 */
	@Override
	public void alarm(boolean state) {
		// TODO Auto-generated method stub
		System.out.println("Hello Enemy, The player is" + state);
		if(state == true) {
			this.afriad = true;
		}else {
			this.afriad = false; 
		}
	}


	@Override
	public int getBlood() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
