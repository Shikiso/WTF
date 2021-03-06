package me.Shikiso.wtf.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.Shikiso.wtf.PluginUtil.ItemManager;
import me.Shikiso.wtf.PluginUtil.Launch;

public class DamageEvent implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getDamager() instanceof Creeper) {
				e.setCancelled(true);
			}
			else if (e.getDamager() instanceof LightningStrike) {
				Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
				if (player.getInventory().getHelmet().getItemMeta().getDisplayName().equals(ItemManager.AntiLightningHelmet.getItemMeta().getDisplayName())) {
					e.setCancelled(true);
				}
			}
		}
		
		if (e.getDamager() instanceof Player) {
			Entity damager = e.getDamager();
			Player player = Bukkit.getPlayer(damager.getUniqueId());
			ItemStack itemInHand = player.getItemInHand();
			
			if (itemInHand.getItemMeta().equals(ItemManager.LaunchPad.getItemMeta())) {
				if (e.getEntity() instanceof Player) {
					Player player2 = Bukkit.getPlayer(e.getEntity().getUniqueId());
					Launch.launchPlayer(player2);
				}
				else {
					Launch.launchPlayer(player);
				}
				itemInHand.setAmount(itemInHand.getAmount()-1);
			}
		}
	}
}