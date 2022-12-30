package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.Shikiso.wtf.PluginUtil.ItemManager;

public class ModifWitherSkeleton implements Listener {
	
	@EventHandler
	public void EntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof WitherSkeleton) {
			Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
			if (player.getInventory().getChestplate() != null) {
				 String ChestplateName = player.getInventory().getChestplate().getItemMeta().getDisplayName();
				 if (ChestplateName.equals(ItemManager.AntiExplosionChestplate.getItemMeta().getDisplayName())) {
					 player.setNoDamageTicks(20);
				 }
			 }
			
			Location loc = e.getDamager().getLocation();
			e.getDamager().getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 0);
			e.getDamager().getWorld().createExplosion(loc, 10);
		}
	}
}
