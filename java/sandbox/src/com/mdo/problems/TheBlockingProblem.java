package com.mdo.problems;

import java.util.Scanner;

import com.mdo.problems.TheBlockingProblem.Block;


public class TheBlockingProblem {
	enum MoveType {
		Over,
		Onto
	}
	
	static class Block {
		// In this scenario, id == index
		int id;
		public Block(int id) {
			this.id = id;
		}
		
		// block that is directly on top of this one
		Block child;
	}
	
	private static Block[] createWorld(int worldSize) {
		Block[] world = new Block[worldSize];
		for(int i = 0; i < world.length; i++) {
			world[i] = new Block(0);
		}
		return world;
	}
	
	private static Block findInStack(Block block, int id) {
		Block currentBlock = block;
		while (currentBlock != null) {
			if (currentBlock.id == id) return currentBlock;
			
			// look at the child
			currentBlock = currentBlock.child;
		}
		return null;
	}
	
	private static Block findBlock(Block[] world, int id) {
		Block foundBlock = null;
		for(int i = 0; i < world.length; i++) {
			foundBlock = findInStack(world[i],id);
			if (foundBlock != null) break;
		}
		return foundBlock;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		Block[] world = createWorld(Integer.parseInt(line));
		// initialize
		while (in.hasNextLine()) {
			line = in.nextLine();
			String[] parts = line.split(" ");
			String cmd = parts[0];
			
			if (cmd != null && cmd.equals("quit")) break;
			
			String moveType = parts[2];
			int victim = Integer.parseInt(parts[1]);
			int target = Integer.parseInt(parts[3]);
			
			// Find victim
			Block victimBlock = findBlock(world,victim);
			Block targetBlock = findBlock(world,target);
			

			if (cmd.equals("move")) {
				// return the children of victims
			}
			
			if (cmd.equals("onto")) {
				// return the children of target
			}
		}
		
	}
}
