package me.Shikiso.wtf.Mobs.Passive;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ModifyChicken implements Listener {
	
	@EventHandler
	public void chickenDeath(EntityDeathEvent event) throws EventException {
		if (event.getEntity() instanceof Chicken) {
			Random rand = new Random();
			
			World world = event.getEntity().getWorld();
			Entity entity = world.getEntities().get(rand.nextInt(world.getEntities().size()));
			Location loc = event.getEntity().getLocation();
			if (entity instanceof Item) {
				event.getEntity().getWorld().spawnEntity(loc, EntityType.CHICKEN);
			}else {
				event.getEntity().getWorld().spawnEntity(loc, entity.getType());
			}
		}
	}
}
