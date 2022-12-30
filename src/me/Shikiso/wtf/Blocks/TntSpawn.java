package me.Shikiso.wtf.Blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.Shikiso.wtf.PluginUtil.ItemManager;

public class TntSpawn implements Listener{

	@EventHandler
	 public void playerMove(PlayerMoveEvent event) {
		 Player player = event.getPlayer();
		 World world = player.getWorld();
		 Location playerLoc = player.getLocation();
		 
		 if (player.getInventory().getChestplate() != null) {
			 String ChestplateName = player.getInventory().getChestplate().getItemMeta().getDisplayName();
			 if (ChestplateName.equals(ItemManager.AntiExplosionChestplate.getItemMeta().getDisplayName())) return;
		 }
		 
		 int X = player.getLocation().getBlockX();
		 int Z = player.getLocation().getBlockZ();
		 int Y = player.getLocation().getBlockY()-1;
		 
		 Location loc = new Location(world, X, Y, Z);
		 Material block = world.getBlockAt(loc).getType();
		 
		 if (block.equals(Material.GRASS_BLOCK)) {
			 int random_num = (int)Math.floor(Math.random() *(100-0+1)+0);
			 if (random_num == 1) {
				 world.spawnEntity(playerLoc, EntityType.PRIMED_TNT);
			 }
		 }
	}
}
