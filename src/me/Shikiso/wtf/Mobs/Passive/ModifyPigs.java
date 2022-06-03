package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ModifyPigs implements Listener {
	
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if (event.getEntityType().equals(EntityType.PIG)) {
			int random_num = (int)Math.floor(Math.random() *(4-0+1)+0);
			if (random_num == 4) {
				event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.ZOGLIN);
			}
		}
	}
}
