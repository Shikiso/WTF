package me.Shikiso.wtf.Mobs.Neutral;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifySpiders implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Spider) {
			Location loc = e.getEntity().getLocation();
			e.getEntity().getWorld().getBlockAt(loc).setType(Material.COBWEB);
		}
	}
}
