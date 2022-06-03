package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class ModifyHorse implements Listener {
	
	@EventHandler
	public void onMount(EntityMountEvent event) {
		if (event.getEntity() instanceof Player) {
			Location loc = event.getEntity().getLocation();
			for (int i=0; i<10; i++) {
				event.getEntity().getWorld().spawnEntity(loc, EntityType.SKELETON);
			}
		}
	}
}
