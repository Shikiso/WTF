package me.Shikiso.wtf.Mobs.Neutral;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ModifyEnderman implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Enderman) {
			Location loc = e.getEntity().getLocation();
			int random_num = (int)Math.floor(Math.random() *(10-0+1)+0);
			if (random_num == 10) {
				e.getEntity().getWorld().getBlockAt(loc).setType(Material.DIAMOND_BLOCK);
				ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
				e.getEntity().getWorld().dropItem(loc, pearl);
				e.getEntity().getWorld().dropItem(loc, pearl);
				e.getDamager().remove();
			}
			else {
				Endermite x = e.getEntity().getWorld().spawn(loc, Endermite.class);
				x.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 10));
				x.playEffect(EntityEffect.WOLF_HEARTS);
			}
		}
	}
}
