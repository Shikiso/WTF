package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import me.Shikiso.wtf.PluginUtil.EditArea;

public class ModifyFish implements Listener {
	
	@EventHandler
	public void onFishDamage(EntityDamageByEntityEvent e) {
		if (e.getEntityType().equals(EntityType.TROPICAL_FISH) ||
				e.getEntityType().equals(EntityType.PUFFERFISH) ||
				e.getEntityType().equals(EntityType.SALMON)) {
			
			Location loc = e.getEntity().getLocation();
			World world = e.getEntity().getWorld();
			
			createOcean(loc, world);	
		}
	}
	
	@EventHandler
	public void fishDeath(EntityDeathEvent e)  {
		if (e.getEntityType().equals(EntityType.TROPICAL_FISH) ||
				e.getEntityType().equals(EntityType.PUFFERFISH) ||
				e.getEntityType().equals(EntityType.SALMON)) {
			Location loc = e.getEntity().getLocation();
			World world = e.getEntity().getWorld();
			
			createOcean(loc, world);
		}
	}
	
	private void createOcean(Location loc, World world) {
		int amount = 15;
		
		int X = loc.getBlockX();
		int Z = loc.getBlockZ();
		int Y = loc.getBlockY();
		
		EditArea.changeBlockIronGolem(EditArea.getBlocksInArea(X, Z, -63, Y+60, amount, world));
		
		for (int i=0; i < 2; i++) {
			world.spawnEntity(loc, EntityType.ELDER_GUARDIAN);
		}
	}
}
