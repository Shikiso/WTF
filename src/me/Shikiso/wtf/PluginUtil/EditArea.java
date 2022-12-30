package me.Shikiso.wtf.PluginUtil;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class EditArea {	
	private static void changeBlockGhast(Block block) {
		if (!block.getType().equals(Material.AIR) && !block.getType().equals(Material.NETHERRACK) &&
				!block.getType().equals(Material.CRIMSON_NYLIUM) && !block.getType().equals(Material.WARPED_NYLIUM) &&
				!block.getType().equals(Material.BEDROCK) && !block.getType().equals(Material.SOUL_SAND) &&
				!block.getType().equals(Material.SOUL_SOIL)) {
			block.setType(Material.LAVA);
		}
	}
	
	private static void changeBlockBlaze(Block block) {
		if (block.getType().equals(Material.LAVA)) {
			block.setType(Material.OBSIDIAN);
		}
	}
	
	private static void changeBlockIronGolem(Block block) {
		block.setType(Material.IRON_BLOCK);
	}
	
	private static void changeBlockFish(Block block) {
		if (block.getType().equals(Material.BEDROCK)) {
			block.setType(Material.MAGMA_BLOCK);
		}else {
			block.setType(Material.WATER);
		}
	}
	
	private static void changeBlockPickaxe(Block block) {
		List<Material> Ores = Arrays.asList(Material.DIAMOND_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.NETHER_GOLD_ORE,
				Material.COAL_ORE, Material.EMERALD_ORE, Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.ANCIENT_DEBRIS);
		
		if (!block.getType().equals(Material.BEDROCK) && !Ores.contains(block.getType())) {
			block.setType(Material.AIR);
		}
	}
	
	public static void getBlocks(int X, int Z, int amount, World world, int type) {
		int x1 = X - amount;
		int z1 = Z - amount;
		
		int x2 = X + amount;
		int z2 = Z + amount;
		
		int lowestX = Math.min(x1, x2);
		int lowestZ = Math.min(z1, z2);
		
		int highestX = lowestX == x1 ? x2 : x1;
		int highestZ = lowestZ == z1 ? z2 : z1;
		
		for (int x = lowestX; x <= highestX; x++) {
			for(int y = -63; y < 319; y++) {
				for (int z = lowestZ; z <= highestZ; z++) {
					Block block = world.getBlockAt(x, y, z);
					if (type == 1) {
						changeBlockGhast(block);
					}else if (type == 2) {
						changeBlockBlaze(block);
					}else if (type == 3) {
						changeBlockIronGolem(block);
					}else if (type == 4) {
						changeBlockFish(block);
					}else if (type == 5) {
						changeBlockPickaxe(block);
					}
				}
			}
		}
	}
}
