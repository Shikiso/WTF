package me.Shikiso.wtf.Mobs.Neutral;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifyBee implements Listener {
	
	@EventHandler
	public void hurtBee(EntityDamageByEntityEvent e) {
		if (e.getEntityType().equals(EntityType.BEE) && e.getDamager() instanceof Player) {
			Location loc = e.getEntity().getLocation();
			World world = e.getEntity().getWorld();
			
			for (int i=0; i < 20; i++) {
				world.spawnEntity(loc, EntityType.BEE);
			}
		}
	}
}
