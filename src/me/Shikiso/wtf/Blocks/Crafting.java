package me.Shikiso.wtf.Blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class Crafting implements Listener {
	Random rand = new Random();
	List<Material> Tools = Arrays.asList(
			Material.WOODEN_AXE, Material.WOODEN_HOE, Material.WOODEN_PICKAXE, Material.WOODEN_SHOVEL, Material.WOODEN_SWORD,
			Material.STONE_AXE, Material.STONE_HOE, Material.STONE_PICKAXE, Material.STONE_SHOVEL, Material.STONE_SWORD,
			Material.IRON_AXE, Material.IRON_HOE, Material.IRON_PICKAXE, Material.IRON_SHOVEL, Material.IRON_SWORD,
			Material.GOLDEN_AXE, Material.GOLDEN_HOE, Material.GOLDEN_PICKAXE, Material.GOLDEN_SHOVEL, Material.GOLDEN_SWORD,
			Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_PICKAXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_SWORD,
			Material.NETHERITE_AXE, Material.NETHERITE_HOE, Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_SWORD);
	
	@EventHandler
	public void Craft(CraftItemEvent event) {		
		Material tool = Tools.get(rand.nextInt(Tools.size()));

		if (event.getRecipe().getResult().getType().equals(tool)) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				rainingTNT(player);
			}
		}
	}
	
	public static void rainingTNT(Player player) {
		Location loc = player.getLocation();
		int X = loc.getBlockX();
		int Z = loc.getBlockZ();
		int Y = loc.getBlockY() + 15;
		int amount = 10;
		
		int x1 = X - amount;
		int z1 = Z - amount;
		
		int x2 = X + amount;
		int z2 = Z + amount;
		
		int lowestX = Math.min(x1, x2);
		int lowestZ = Math.min(z1, z2);
		
		int highestX = lowestX == x1 ? x2 : x1;
		int highestZ = lowestZ == z1 ? z2 : z1;
		
		for (int x = lowestX; x <= highestX; x++) {
			for(int y=Y; y < Y+2; y++) {
				for (int z = lowestZ; z <= highestZ; z++) {
					int random_num = (int)Math.floor(Math.random() *(10-0+1)+0);
					if (random_num == 1) {
						Block block = player.getWorld().getBlockAt(x, y, z);
						TNTPrimed tnt = block.getWorld().spawn(block.getLocation(),TNTPrimed.class);
					}
				}
			}
		}
	}
}






