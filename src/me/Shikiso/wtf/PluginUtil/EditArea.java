package me.Shikiso.wtf.PluginUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class EditArea {
	
	public static void changeBlockGhast(List<Block> blocksInArea) {
		for (Block block : blocksInArea) {
			if (!block.getType().equals(Material.AIR) && !block.getType().equals(Material.NETHERRACK) &&
					!block.getType().equals(Material.CRIMSON_NYLIUM) && !block.getType().equals(Material.WARPED_NYLIUM) &&
					!block.getType().equals(Material.BEDROCK) && !block.getType().equals(Material.SOUL_SAND) &&
					!block.getType().equals(Material.SOUL_SOIL)) {
				block.setType(Material.LAVA);
			}
		}
	}
	
	public static void changeBlockBlaze(List<Block> blocksInArea) {
		for (Block block : blocksInArea) {
			if (block.getType().equals(Material.LAVA)) {
				block.setType(Material.OBSIDIAN);
			}
		}
	}
	
	public static void changeBlockIronGolem(List<Block> blocksInArea) {
		for (Block block : blocksInArea) {
			block.setType(Material.IRON_BLOCK);
		}
	}
	
	public static void changeBlockFish(List<Block> blocksInArea) {
		for (Block block : blocksInArea) {
			if (block.getType().equals(Material.BEDROCK)) {
				block.setType(Material.MAGMA_BLOCK);
			}else {
				block.setType(Material.WATER);
			}
		}
	}
	
	public static void changeBlockPickaxe(List<Block> blocksInArea) {
		List<Material> Ores = Arrays.asList(Material.DIAMOND_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.NETHER_GOLD_ORE,
				Material.COAL_ORE, Material.EMERALD_ORE, Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.ANCIENT_DEBRIS);
		
		for (Block block : blocksInArea) {
			if (!block.getType().equals(Material.BEDROCK) && !Ores.contains(block.getType())) {
				block.setType(Material.AIR);
			}
		}
	}
	
	public static void changeBlockBarrier(List<Block> blocksInArea) {
		for (Block block : blocksInArea) {
			if (block.getType().equals(Material.AIR)) {
				block.setType(Material.BARRIER);
			}
			else if (block.getType().equals(Material.BARRIER)) {
				block.setType(Material.AIR);
			}
		}
	}
	
	public static List<Block> getBlocksInArea(int X, int Z, int MinY, int MaxY, int radius, World world) {
		List<Block> blocksInArea = new ArrayList<>();
		
		int x1 = X - radius;
		int z1 = Z - radius;
		
		int x2 = X + radius;
		int z2 = Z + radius;
		
		int lowestX = Math.min(x1, x2);
		int lowestZ = Math.min(z1, z2);
		
		int highestX = lowestX == x1 ? x2 : x1;
		int highestZ = lowestZ == z1 ? z2 : z1;
		
		for (int x = lowestX; x <= highestX; x++) {
			for(int y = MinY; y < MaxY; y++) {
				for (int z = lowestZ; z <= highestZ; z++) {
					Block block = world.getBlockAt(x, y, z);
					blocksInArea.add(block);
				}
			}
		}
		
		return blocksInArea;
	}
}
