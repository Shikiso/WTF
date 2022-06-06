package me.Shikiso.wtf.Mobs.Boss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModifyEnderDragon implements Listener {
	
	public static ItemStack D;
	public static ItemStack E;
	public static ItemStack G;
	
	public static List<Player> players = (List<Player>) Bukkit.getServer().getOnlinePlayers();
	public static List<ItemStack> Items = Arrays.asList(D, E, G);
	
	
	public static void init() {
		D = diamondItem();
		E = emeraldItem();
		G = goldItem();
		
	}
	
	public static ItemStack diamondItem() {
		D = new ItemStack(Material.DIAMOND);
		ItemMeta XMeta = D.getItemMeta();
		XMeta.setDisplayName(ChatColor.RED + "DON'T PICK ME UP");
		D.setItemMeta(XMeta);
		return D;
	}
	
	public static ItemStack emeraldItem() {
		E = new ItemStack(Material.EMERALD);
		ItemMeta XMeta = E.getItemMeta();
		XMeta.setDisplayName(ChatColor.RED + "DON'T PICK ME UP");
		E.setItemMeta(XMeta);
		return E;
	}
	
	public static ItemStack goldItem() {
		G = new ItemStack(Material.GOLD_INGOT);
		ItemMeta XMeta = G.getItemMeta();
		XMeta.setDisplayName(ChatColor.RED + "DON'T PICK ME UP");
		G.setItemMeta(XMeta);
		return G;
	}
	
	@EventHandler
	public void EnderDragonDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof EnderDragon) {
			World w = e.getEntity().getWorld();
			Location l = e.getEntity().getLocation();
			if ((int)Math.floor(Math.random() *(15-0+1)+0) < 1) {
				w.spawnEntity(l, EntityType.TROPICAL_FISH);
			}
		}
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		if (event.getEntity() instanceof EnderCrystal) {
			int X = event.getEntity().getLocation().getBlockX();
			int Y = event.getEntity().getLocation().getBlockY();
			int Z = event.getEntity().getLocation().getBlockZ();
			
			for (int i=0; i < 20; i++) {
				event.getEntity().getWorld().spawnEntity(new Location(event.getEntity().getWorld(), X, Y+i, Z), EntityType.GHAST);
			}
		}
	}
	
	@EventHandler
	public void playerMove(PlayerMoveEvent event) {
		Random rand = new Random();
		
		ItemStack item = Items.get(rand.nextInt(Items.size()));
		
		Player p = players.get(rand.nextInt(players.size()));
		Location loc = p.getLocation();
		World world = p.getWorld();
		
		if (world.getName().equals("world_the_end")) {
			if ((int)Math.floor(Math.random() *(300-0+1)+0) == 1) {
				world.dropItem(loc, item);
			}
		}
	}
	
	@EventHandler
	public void PickupItem(PlayerPickupItemEvent event) {
		if (D != null) {
			ItemStack item = event.getItem().getItemStack();
			if (item.equals(D) || item.equals(E) || item.equals(G)) {
				Location loc = event.getPlayer().getLocation();
				World world = event.getPlayer().getWorld();
			
				world.spawnEntity(loc, EntityType.WITHER);
			}
		}
	}
}

