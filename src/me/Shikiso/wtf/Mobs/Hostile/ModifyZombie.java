package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.Location;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ModifyZombie implements Listener {
	
	@EventHandler
	public void zombieSpawn(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Zombie) {
			if (event.getEntity().getHeight() > 1.00) {
				Location loc = event.getEntity().getLocation();
				Zombie x = event.getEntity().getWorld().spawn(loc, Zombie.class);
				x.setBaby(true);
				event.getEntity().remove();
			}
		}
	}
}
