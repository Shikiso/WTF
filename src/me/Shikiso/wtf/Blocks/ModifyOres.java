package me.Shikiso.wtf.Blocks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ModifyOres implements Listener {
	
	@EventHandler
	 public void onBlockBreak(BlockBreakEvent event) {
		 ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
		 ItemStack iron = new ItemStack(Material.IRON_BLOCK);
		 ItemStack gold = new ItemStack(Material.GOLD_BLOCK);
		 ItemStack coal = new ItemStack(Material.COAL_BLOCK);
		 ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK);
		 ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
		 ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK);
		 ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
		 
		 Block block = event.getBlock();
		 if (block.getType().equals(Material.DIAMOND_ORE)){
			 event.setDropItems(false);
			 block.getWorld().dropItem(block.getLocation(), diamond);
		 }
		else if (block.getType().equals(Material.IRON_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), iron);
		}
		else if (block.getType().equals(Material.GOLD_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), gold);
		}
		else if (block.getType().equals(Material.NETHER_GOLD_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), gold);
		}
		else if (block.getType().equals(Material.COAL_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), coal);
		}
		else if (block.getType().equals(Material.EMERALD_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), emerald);
		}
		else if (block.getType().equals(Material.REDSTONE_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), redstone);
		}
		else if (block.getType().equals(Material.LAPIS_ORE)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), lapis);
		}
		else if (block.getType().equals(Material.ANCIENT_DEBRIS)) {
			event.setDropItems(false);
			block.getWorld().dropItem(block.getLocation(), netherite);
		}
	 }
}
