package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifWitherSkeleton implements Listener {
	
	@EventHandler
	public void EntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof WitherSkeleton) {
			Location loc = e.getDamager().getLocation();
			e.getDamager().getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 0);
			e.getDamager().getWorld().createExplosion(loc, 10);
		}
	}
}
