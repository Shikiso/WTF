package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Shikiso.wtf.PluginUtil.ItemManager;

public class ModifyCreeper implements Listener {
	
	public static ItemStack diamonds;
	public static ItemMeta diamondsMeta;
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		if (event.getEntity() instanceof Creeper) {
			event.setCancelled(true);
			
			diamonds = new ItemStack(Material.DIAMOND);
			diamondsMeta = diamonds.getItemMeta();
			diamondsMeta.setDisplayName(ChatColor.RED + "DON'T PICK ME UP");
			diamonds.setItemMeta(diamondsMeta);
			
			event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), diamonds);
		}
	}
	
	@EventHandler
	public void PickupItem(PlayerPickupItemEvent event) {
		if (event.getItem().getItemStack().getItemMeta().equals(diamondsMeta)) {
			event.setCancelled(true);
			if (event.getPlayer().getInventory().getChestplate() != null) {
				if (event.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName().equals(ItemManager.AntiExplosionChestplate.getItemMeta().getDisplayName())) {
					event.getPlayer().setNoDamageTicks(20);
				}
			}
			event.getPlayer().getWorld().createExplosion(event.getPlayer().getLocation(), 50);
		}
	}

}
