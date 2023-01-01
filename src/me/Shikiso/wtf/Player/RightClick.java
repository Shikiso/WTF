package me.Shikiso.wtf.Player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.Shikiso.wtf.PluginUtil.EditArea;
import me.Shikiso.wtf.PluginUtil.ItemManager;
import me.Shikiso.wtf.PluginUtil.Launch;

public class RightClick implements Listener {
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		
		Action action = event.getAction();
		Player player = event.getPlayer();
		
		if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			ItemStack item = player.getItemInHand();
			if (item.getItemMeta() == null) return;
			if (item.getType().equals(Material.BARRIER)) {
				event.setCancelled(true);
			}
			
			if (item.getItemMeta().equals(ItemManager.FlyingFeather.getItemMeta())) {
				player.setAllowFlight(true);
				player.setFlying(true);
				item.setType(Material.CHICKEN_SPAWN_EGG);
			}
			else if (item.getItemMeta().equals(ItemManager.LaunchPad.getItemMeta())) {
				Launch.launchPlayer(player);
				item.setAmount(item.getAmount() - 1);
			}
			else if (event.getMaterial().equals(Material.BELL) &&
					action == Action.RIGHT_CLICK_BLOCK &&
					!event.getClickedBlock().getType().equals(Material.BELL)) {
				
				player.getInventory().addItem(new ItemStack(Material.BARRIER, 1));
				Location bellLoc = event.getClickedBlock().getLocation();
				int radius = 60;
				int X = bellLoc.getBlockX();
				int Z = bellLoc.getBlockZ();
				
				EditArea.getBlocks(X, Z, radius, player.getWorld(), 6);
				EditArea.getBlocks(X, Z, radius-1, player.getWorld(), 6);
			}
		}
	}
}
