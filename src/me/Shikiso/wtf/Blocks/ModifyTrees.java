package me.Shikiso.wtf.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ModifyTrees implements Listener {
	
	List<Block> blocksInChunk = new ArrayList<Block>();
	List<Material> safeBlocks = Arrays.asList(Material.AIR, Material.VOID_AIR, Material.CHEST, Material.MINECART, Material.CHEST_MINECART,
			Material.DIAMOND_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.COAL_ORE, Material.EMERALD_ORE, Material.REDSTONE_ORE,
			Material.LAPIS_ORE, Material.ANCIENT_DEBRIS, Material.GRASS);
	List<Material> blocks = Arrays.asList(Material.OAK_LOG, Material.ACACIA_LOG, Material.BIRCH_LOG, Material.DARK_OAK_LOG, Material.JUNGLE_LOG,
			Material.SPRUCE_LOG);
	
	Random rand = new Random();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {		
		Material brokenBlock = event.getBlock().getType();
		if (blocks.contains(brokenBlock)) {
			getBlocks(event.getPlayer().getLocation(), event.getPlayer().getWorld());
		}
	}
	
	public void changeBlock(Block block) {
		if (!safeBlocks.contains(block.getType())) {
			Material newBlock = Material.GLASS; //blocksInChunk.get(rand.nextInt(blocksInChunk.size())).getType();
			if (!safeBlocks.contains(newBlock)) {
				block.setType(newBlock);
			}
		}
	}
	
	public void getBlocks(Location loc, World world) {
		int X = loc.getBlockX();
		int amount = 16;
		int Z = loc.getBlockZ();
		
		int x1 = X - amount;
		int z1 = Z - amount;
		
		int x2 = X + amount;
		int z2 = Z + amount;
		
		int lowestX = Math.min(x1, x2);
		int lowestZ = Math.min(z1, z2);
		
		int highestX = lowestX == x1 ? x2 : x1;
		int highestZ = lowestZ == z1 ? z2 : z1;
		
		for (int x = lowestX; x <= highestX; x++) {
			for(int y = 0; y < 128; y++) {
				for (int z = lowestZ; z <= highestZ; z++) {
					Block block = world.getBlockAt(x, y, z);
					blocksInChunk.add(block);
				}
			}
		}
		
		for (Block block : blocksInChunk) {
			changeBlock(block);
		}
	}
}
