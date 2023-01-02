package me.Shikiso.wtf.Player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import me.Shikiso.wtf.PluginUtil.ItemManager;
import me.Shikiso.wtf.PluginUtil.Launch;

public class DamageEvent implements Listener {
	
	void playerDiedWithBoots(Player player) {
		player.setHealth(20);
		player.sendMessage("YOU DIED!");
		
		Location loc = player.getLocation();
		int random_num1 = (int)Math.floor(Math.random() *(100-0+1)+0);
		int random_num2 = (int)Math.floor(Math.random() *(100-0+1)+0);
		
		
		int X = loc.getBlockX() + random_num1;
		int Y = loc.getBlockY();
		int Z = loc.getBlockZ() + random_num2;
		
		Location newLoc = new Location(player.getWorld(), X, Y, Z);
		player.getWorld().createExplosion(newLoc, 40);
		player.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 0);
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
			
			if (player.getInventory().getBoots().getItemMeta() != null) {
				if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals(ItemManager.ImmortalBoots.getItemMeta().getDisplayName())) {
					if (e.getDamage() >= player.getHealth()) {
						e.setCancelled(true);
						playerDiedWithBoots(player);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamageByEntity(EntityDamageByEntityEvent e) {
		int timesDied = 1;
		
		if (e.getEntity() instanceof Player) {
			Player player = Bukkit.getPlayer(e.getEntity().getUniqueId());
			if (e.getDamager() instanceof Creeper) {
				e.setCancelled(true);
			}
			else if (e.getDamager() instanceof LightningStrike && player.getInventory().getHelmet().getItemMeta() != null) {
				if (player.getInventory().getHelmet().getItemMeta().getDisplayName().equals(ItemManager.AntiLightningHelmet.getItemMeta().getDisplayName())) {
					e.setCancelled(true);
				}
			}
			
			if (player.getInventory().getBoots().getItemMeta() != null) {
				if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals(ItemManager.ImmortalBoots.getItemMeta().getDisplayName())) {
					if (e.getDamage() >= player.getHealth()) {
						e.setCancelled(true);
						playerDiedWithBoots(player);
					}
				}
			}
		}
		
		if (e.getDamager() instanceof Player) {
			Entity damager = e.getDamager();
			Player player = Bukkit.getPlayer(damager.getUniqueId());
			
			ItemStack itemInHand = player.getItemInHand();
			
			if (itemInHand.getItemMeta() == null) return;
			
			if (itemInHand.getItemMeta().equals(ItemManager.LaunchPad.getItemMeta())) {
				if (e.getEntity() instanceof Player) {
					Player player2 = Bukkit.getPlayer(e.getEntity().getUniqueId());
					Launch.launchPlayer(player2);
				}
				else {
					Launch.launchMob(e.getEntity());
				}
				itemInHand.setAmount(itemInHand.getAmount()-1);
			}
		}
	}
}