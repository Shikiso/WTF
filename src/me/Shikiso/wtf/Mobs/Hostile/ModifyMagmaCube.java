package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ModifyMagmaCube implements Listener {
	
	@EventHandler
	public void spawn(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof MagmaCube) {
			event.getEntity().setGravity(false);
		}
		else {
			int random_num = (int)Math.floor(Math.random() *(100-0+1)+0);
			if (random_num == 1) {
				Location loc = event.getEntity().getLocation();
				event.getEntity().getWorld().spawnEntity(loc, EntityType.MAGMA_CUBE);
				event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.LEVITATION, 10, 5)));
			}
		}
	}
}
