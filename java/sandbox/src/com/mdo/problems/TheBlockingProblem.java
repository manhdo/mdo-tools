package com.mdo.problems;

import java.io.InputStream;
import java.util.Scanner;


public class TheBlockingProblem {
	enum MoveType {
		Over,
		Onto
	}
	
	// Simple Block node
	static class Block {
		// In this scenario, id == index
		int id;
		public Block(int id) {
			this.id = id;
		}
		
		// block that is directly on top of this one
		Block above;
		Block below;
	}
	
	private static Block[] createWorld(int worldSize) {
		Block[] world = new Block[worldSize];
		for(int i = 0; i < world.length; i++) {
			world[i] = new Block(i);
		}
		return world;
	}
	
	private static Block findInStack(Block block, int id) {
		Block currentBlock = block;
		while (currentBlock != null) {
			if (currentBlock.id == id) return currentBlock;
			
			// look at the child
			currentBlock = currentBlock.above;
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
	
	private static void sendTopBlocksHome(Block[] world, Block block) {
		Block current = block.above;
		block.above = null;
		while (current != null) {
			world[current.id] = current;
			current.below = null;
			Block tmp = current;
			current = current.above;
			tmp.above = null;
		}
	}
	
	private static Block findBottomBlock(Block block) {
		Block c = block;
		while (c.below != null) {
			c = c.below;
		}
		
		return c;
	}
	
	private static void addToTopOfStack(Block[] world, Block victim, Block target) {
		if (world[victim.id] == victim) {
			world[victim.id] = null;
		} else {
			// not top of stack
			if (victim.below != null) {
				victim.below.above = null;
			}
			victim.below = null;
		}
		
		Block topBlock = target;
		while(topBlock.above != null) {
			topBlock = topBlock.above;
		}

		topBlock.above = victim;
		victim.below = topBlock;
	}
	
	public static void main(String[] args) {
		InputStream inputStream= TheBlockingProblem.class.getResourceAsStream("input.data");
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(inputStream);
		
		String line = in.nextLine();
		Block[] world = createWorld(Integer.parseInt(line));
		// initialize
		while (in.hasNextLine()) {
			line = in.nextLine();
			//System.out.println(line);
			String[] parts = line.split(" ");
			String cmd = parts[0];
			
			if (cmd != null && cmd.equals("quit")) break;
			
			String moveType = parts[2];
			int victim = Integer.parseInt(parts[1]);
			int target = Integer.parseInt(parts[3]);
			
			// Find victim
			Block movingBlock = findBlock(world,victim);
			Block targetBlock = findBlock(world,target);
			
			Block movingRoot = findBottomBlock(movingBlock);
			Block targetRoot = findBottomBlock(targetBlock);
			
			if (movingRoot.id == targetRoot.id) continue; 
			
			
			if (cmd.equals("move")) {
				// return the children of victims
				sendTopBlocksHome(world, movingBlock);
			}
			
			if (moveType.equals("onto")) {
				// return the children of target
				sendTopBlocksHome(world, targetBlock);
			}
			
			addToTopOfStack(world,movingBlock, targetBlock);
		}
		
		
		// Output the result
		for(int i = 0; i < world.length; i++) {
			System.out.print(i + ":");

			Block block = world[i];
			while (block != null) {
				System.out.print(" " + block.id);
				block = block.above;
			}
			System.out.print("\n");
		}
	}
}
