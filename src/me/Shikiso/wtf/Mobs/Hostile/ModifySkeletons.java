package me.Shikiso.wtf.Mobs.Hostile;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ModifySkeletons implements Listener {
	
	@EventHandler
	public void ProjectileShoot(ProjectileLaunchEvent event) {
		if (event.getEntity().getShooter() instanceof Skeleton) {
			int random_num = (int)Math.floor(Math.random() *(2-0+1)+0);
			if (random_num == 2) {
				event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.SKELETON);
			}
		}
	}
}
