package me.Shikiso.wtf.GameEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

public class TNT implements Listener{
	
	@EventHandler
    public void onBombExplode(EntityExplodeEvent e){
		if (e.getEntityType().equals(EntityType.PRIMED_TNT)) {
			Location tntLoc = e.getEntity().getLocation();
			World world = e.getEntity().getWorld();
			Location higherLoc1 = new Location(world, tntLoc.getBlockX(), tntLoc.getBlockY()+4, tntLoc.getBlockZ());
			
			int random_num = (int)Math.floor(Math.random() *(5-0+1)+0);
			if (random_num > 1) {
				e.setCancelled(true);
			}
			if (random_num == 2) {
				world.createExplosion(tntLoc, 20);
			}
			else if (random_num == 3){
				for (int i=0;i<10;i++) {
					world.dropItem(higherLoc1, new ItemStack(Material.NETHERITE_INGOT));
				}
			}
			else if (random_num == 4) {
				for (int i=0;i<5;i++) {
					Location newLoc = new Location(world, tntLoc.getBlockX()+i, tntLoc.getBlockY()+20, tntLoc.getBlockZ()+i);
					world.spawn(newLoc, Giant.class);
				}
			}
			else if (random_num == 5) {
				for (int i=0;i<15;i++) {
					Location newLoc = new Location(world, tntLoc.getBlockX()+i, tntLoc.getBlockY()+40, tntLoc.getBlockZ()+i);
					world.spawnFallingBlock(newLoc, new ItemStack(Material.ANVIL).getData());
				}
			}
		}
	}
}
