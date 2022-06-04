package me.Shikiso.wtf.Mobs.Passive;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ModifySheep implements Listener {
	
	@EventHandler
	public void hurtSheep(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Sheep && e.getDamager() instanceof Player) {
			double damage = e.getDamage();
			Player player = Bukkit.getPlayer(e.getDamager().getUniqueId());
			if (player.getHealth() <= 20 && player.getHealth() > 0) {
				if (player.getHealth()-damage <= 0) {
					player.setHealth(0);
				}else {
					player.setHealth(player.getHealth()-damage);
				}
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_DEATH, 1, 0);
			}
		}
	}
}
