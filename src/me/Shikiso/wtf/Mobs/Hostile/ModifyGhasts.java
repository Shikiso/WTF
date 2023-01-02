package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.entity.Ghast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import me.Shikiso.wtf.PluginUtil.EditArea;

public class ModifyGhasts implements Listener {
	
	@EventHandler
	public void ProjectileShoot(ProjectileLaunchEvent event) {
		if (event.getEntity().getShooter() instanceof Ghast) {
			int X = event.getEntity().getLocation().getBlockX();
			int amount = 20;
			int Z = event.getEntity().getLocation().getBlockZ();
			
			EditArea.changeBlockGhast(EditArea.getBlocksInArea(X, Z, -63, 319, amount, event.getEntity().getWorld()));
		}
	}
}
