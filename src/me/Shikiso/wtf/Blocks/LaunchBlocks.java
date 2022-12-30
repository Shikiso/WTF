package me.Shikiso.wtf.Blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.Shikiso.wtf.PluginUtil.Launch;

public class LaunchBlocks implements Listener {
	
	 @EventHandler
	 public void playerMove(PlayerMoveEvent event) {
		 Player player = event.getPlayer();
		 World world = player.getWorld();
		 
		 int X = player.getLocation().getBlockX();
		 int Z = player.getLocation().getBlockZ();
		 int Y = player.getLocation().getBlockY()-1;
		 
		 Location loc = new Location(world, X, Y, Z);
		 Material block = world.getBlockAt(loc).getType();
		 
		 if (block.equals(Material.ANDESITE) || block.equals(Material.DIORITE) || block.equals(Material.GRANITE)) {
			 Launch.launchPlayer(player);
		 }
	 }
}