package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifyGoodAnimal implements Listener {
	
	@EventHandler
	public void hurtAnimal(EntityDamageByEntityEvent e) {
		if (e.getEntityType().equals(EntityType.PARROT) || e.getEntityType().equals(EntityType.SQUID) ||
				e.getEntityType().equals(EntityType.OCELOT) || e.getEntityType().equals(EntityType.CAT) ||
				e.getEntityType().equals(EntityType.TURTLE) || e.getEntityType().equals(EntityType.PANDA)) {
			e.getDamager().teleport(new Location(e.getEntity().getWorld(), 0, 0, 0));
		}
	}
}