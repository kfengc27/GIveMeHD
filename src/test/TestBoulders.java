package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.DungeonLoader;
import unsw.dungeon.Player;
import unsw.dungeon.Switch;
import unsw.dungeon.Wall;

public class TestBoulders {
	DungeonLoader loader = null;
	Dungeon dungeon = new Dungeon(5, 5, loader);
	Player player = new Player(dungeon,1, 1);
	Boulder boulder = new Boulder(1, 2);
	Boulder boulder2 = new Boulder(2, 3);
	Wall wall = new Wall(0, 2);
	Switch s = new Switch(1, 4);
	Switch s2 = new Switch(3, 3);
	
	
	@Test
	public void testPush() {
		//push the boulder down
		dungeon.setPlayer(player);
		dungeon.addBoulder(boulder);
		player.moveDown();
		assertEquals(player.getY(), 2);
		assertEquals(boulder.getY(), 3);
	}
	
	@Test
	public void testWall() {
		dungeon.setPlayer(player);
		dungeon.addBoulder(boulder);
		dungeon.addWall(wall);
		player.moveRight();
		player.moveDown();
		player.moveLeft();
		//the position of the boulder should not change
		//because the left is wall
		assertEquals(boulder.getX(), 1);
		assertEquals(boulder.getY(), 2);
	}
	
	@Test
	public void testDone() {
		dungeon.setGoal("boulders");
		dungeon.setPlayer(player);
		dungeon.addBoulder(boulder);
		dungeon.addBoulder(boulder2);
		dungeon.addSwitch(s);
		dungeon.addSwitch(s2);
		player.moveDown();
		player.moveDown();
		player.moveRight();
		assertEquals(player.Success(), true);
	}
}
