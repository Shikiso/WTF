package me.Shikiso.wtf.Mobs.Utility;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ModifySnowGolems implements Listener {
	
	@EventHandler
	public void snowgolemSpawn(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Snowman) {
			freezeLand(event.getEntity().getLocation(), event.getEntity().getWorld());
		}
	}

	private void freezeLand(Location loc, World world) {
		int amount = 100;
		
		int X = loc.getBlockX();
		int Z = loc.getBlockZ();
		
		int x1 = X - amount;
		int z1 = Z - amount;
		
		int x2 = X + amount;
		int z2 = Z + amount;
		
		int lowestX = Math.min(x1, x2);
		int lowestZ = Math.min(z1, z2);
		int lowestY = loc.getBlockY()-3;
		
		int highestX = lowestX == x1 ? x2 : x1;
		int highestZ = lowestZ == z1 ? z2 : z1;
		
		for (int x = lowestX; x <= highestX; x++) {
			for(int y = lowestY; y < 128; y++) {
				for (int z = lowestZ; z <= highestZ; z++) {
					Block block = world.getBlockAt(x, y, z);
					if (block.getType().equals(Material.WATER)) {
						block.setType(Material.ICE);
					}
					else if (!block.getType().equals(Material.AIR)){
						block.setType(Material.SNOW_BLOCK);
					}
				}
			}
		}
			
	}
}
