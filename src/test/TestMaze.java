package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.*;
import org.junit.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.DungeonApplication;
import unsw.dungeon.DungeonLoader;
import unsw.dungeon.Exit;
import unsw.dungeon.Player;
import unsw.dungeon.Wall;

public class TestMaze {
	DungeonLoader loader = null;
	Dungeon dungeon = new Dungeon(5, 5, loader);
	Player player = new Player(dungeon,1, 1);
	Wall wall = new Wall(0, 1);
	Exit exit = new Exit(1, 4);
	
	@Test	
	public void testMoveRight() {
		player.moveRight();
		assertEquals(player.getX(), 2);
		assertEquals(player.getY(), 1);
	}
	
	@Test
	public void testMoveDown() {
		player.moveDown();
		assertEquals(player.getX(), 1);
		assertEquals(player.getY(), 2);
	}
	
	@Test
	public void testMoveUp() {
		player.moveUp();
		assertEquals(player.getX(), 1);
		assertEquals(player.getY(), 0);
	}
	
	@Test
	public void testWall() {		
		//In this case, player should remain in the same position
		//because the left is wall	
		dungeon.addWall(wall);
		player.moveLeft();
		assertEquals(player.getX(), 1);
		assertEquals(player.getY(), 1);
	}
	
	@Test
	public void testExit() {
		dungeon.setGoal("exit");
		dungeon.setExit(exit);
		dungeon.setPlayer(player);
		assertEquals(player.Success(), false);
		player.moveDown();
		player.moveDown();
		player.moveDown();
		assertEquals(player.Success(), true);
	}
	   
}
