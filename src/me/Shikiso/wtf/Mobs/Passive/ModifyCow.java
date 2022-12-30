package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifyCow implements Listener {
	
	@EventHandler
	public void hurtCow(EntityDamageByEntityEvent e) {
		if (e.getEntity().getType().equals(EntityType.COW)) {
			Location loc = e.getEntity().getLocation();
			e.getEntity().remove();
			e.getEntity().getWorld().spawnEntity(loc, EntityType.MUSHROOM_COW);
		}
		else if (e.getEntity().getType().equals(EntityType.MUSHROOM_COW)) {
			Location loc = e.getEntity().getLocation();
			e.getEntity().remove();
			e.getEntity().getWorld().spawnEntity(loc, EntityType.COW);
		}
	}
}
