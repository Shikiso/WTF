package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ModifySilverfish implements Listener {
	 
	@EventHandler
	public void EntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Silverfish) {
			e.getDamager().getWorld().spawnEntity(e.getDamager().getLocation(), EntityType.SILVERFISH);
		}
	}
	
	@EventHandler
	public void spawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Silverfish) {
			e.getEntity().setCustomName("( ͡° ͜ʖ ͡°)");
			e.getEntity().setCustomNameVisible(true);
			e.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 1000));
		}
	}	
}
