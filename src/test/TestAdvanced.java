package test;

import org.junit.Test;

import unsw.dungeon.Bomb;
import unsw.dungeon.Dungeon;
import unsw.dungeon.DungeonLoader;
import unsw.dungeon.Enemy;
import unsw.dungeon.Invincibility;
import unsw.dungeon.Player;
import unsw.dungeon.Sword;
import unsw.dungeon.Treasure;
import unsw.dungeon.Wall;

public class TestAdvanced {
	DungeonLoader loader = null;
	Dungeon dungeon = new Dungeon(7, 7, loader);
	Player player = new Player(dungeon,1, 1);
	Enemy enemy = new Enemy(dungeon, 1, 3);
	Treasure treasure = new Treasure(0, 1);
	Sword sword = new Sword(dungeon, 1, 2);
	Invincibility invincibility = new Invincibility();
	Bomb bomb = new Bomb();
	
	@Test
	//whether enemy disappear or not
	public void testKillEnemy() {
		dungeon.setPlayer(player);
		dungeon.setEnemy();
		
		
	}
	
	@Test
	//The treasure disppears after pickup and added to backpack
	public void testTreasure() {

	}
	
	@Test
	//The Sword disppears after pickup and added to backpack
	//And can use 5 times
	public void testSword() {

	}
	
	@Test
	//The potion disppears after pickup and added to backpack
	//It can keep you invincible for 10 sec
	public void testInvincibility() {

	}
	
	@Test
	//The bomb disppear after pickup and added to backpack
	public void testBomb() {

	}

}
