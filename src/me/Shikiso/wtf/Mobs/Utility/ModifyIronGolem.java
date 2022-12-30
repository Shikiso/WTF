package me.Shikiso.wtf.Mobs.Utility;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.Shikiso.wtf.PluginUtil.EditArea;

public class ModifyIronGolem implements Listener {
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof IronGolem && e.getDamager() instanceof Player) {
			Entity player = e.getDamager();
			Location playerLocation = player.getLocation();
			World world = e.getEntity().getWorld();
			
			int amount = 2;
			int X = playerLocation.getBlockX();
			int Z = playerLocation.getBlockZ();
			
			EditArea.getBlocks(X, Z, amount, world, 3);
		}
	}
}
