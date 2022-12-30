package me.Shikiso.wtf.Mobs.Boss;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class ModifyWither implements Listener {
	
	boolean witherSpawned = false;
		
	@EventHandler
	public void witherSpawn(CreatureSpawnEvent event) throws InterruptedException {
		if (event.getEntity() instanceof Wither && witherSpawned == false) {
			witherSpawned = true;
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "You're insane...");
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "So im going to make this hell");
			TimeUnit.SECONDS.sleep(5);
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "LITERALLY");
			
			World world = Bukkit.getWorld("world_nether");
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.setNoDamageTicks(20);
				player.teleport(world.getSpawnLocation());
			}
			
			event.getEntity().teleport(world.getSpawnLocation());
			for (int i=0; i<3; i++) {
				world.spawnEntity(event.getEntity().getLocation(), EntityType.WITHER);
			}
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "Have fun! ;)");
		}
	}
	
	@EventHandler
	public void witherDie(EntityDeathEvent event) {
		if (event.getEntity() instanceof Wither) {
			witherSpawned = false;
		}
	}
}
