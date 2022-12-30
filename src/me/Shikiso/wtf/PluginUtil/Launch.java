package me.Shikiso.wtf.PluginUtil;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Launch {
	
	public static void launchPlayer(Player player) {
		World world = player.getWorld();
		Location playerLoc = player.getLocation();
		 
		player.addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 3)));
		for (int i=0; i<5; i++) {
			 world.createExplosion(playerLoc, 1);
		}
	}
	
	public static void launchMob(Entity entity) {
		World world = entity.getWorld();
		Location loc = entity.getLocation();
		entity.teleport(new Location(loc.getWorld(), loc.getX(), 100, loc.getZ()));
		 
		for (int i=0; i<5; i++) {
			 world.createExplosion(loc, 1);
		}
	}
	
	public static void launchAllMobs() {
		System.out.println(1);
		Random rand = new Random();
		
		for (World world : Bukkit.getWorlds()) {
			System.out.println(2);
			for (int i = 0; i > 20; i++) {
				Entity entity = world.getEntities().get(rand.nextInt(world.getEntities().size()));
				Location loc = entity.getLocation();
				System.out.println(3);
				for (int x=0; x<5; x++) {
					 world.createExplosion(loc, 1);
				}
			}
		}
	}
}
