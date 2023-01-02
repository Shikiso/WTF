package me.Shikiso.wtf.Mobs.Hostile;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Shikiso.wtf.PluginUtil.EditArea;

public class ModifyBlazes implements Listener {	
	@EventHandler
	public void ProjectileShoot(ProjectileLaunchEvent event) {
		if (event.getEntity().getShooter() instanceof Blaze) {			
			int X = event.getEntity().getLocation().getBlockX();
			int amount = 20;
			int Z = event.getEntity().getLocation().getBlockZ();
			
			EditArea.changeBlockBlaze(EditArea.getBlocksInArea(X, Z, -63, 319, amount, event.getEntity().getWorld()));
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Blaze) {
			Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
			player.addPotionEffect((new PotionEffect(PotionEffectType.LEVITATION, 20, 30)));
		}
	}
	
	@EventHandler
	public void EntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Fireball) {
			Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
			player.addPotionEffect((new PotionEffect(PotionEffectType.LEVITATION, 20, 30)));
		}
	}
}