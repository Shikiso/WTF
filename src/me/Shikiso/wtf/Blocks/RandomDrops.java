package me.Shikiso.wtf.Blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.Shikiso.wtf.PluginUtil.EditArea;
import me.Shikiso.wtf.PluginUtil.ItemManager;

public class RandomDrops implements Listener {
	Random rand = new Random();
	
	List<ItemStack> SpecialItems = Arrays.asList(ItemManager.ImmortalBoots, ItemManager.OPSword, ItemManager.PickaxeDrill,
			ItemManager.YeetStick, ItemManager.LaunchPad, ItemManager.FlyingFeather, ItemManager.AntiLightningHelmet);
	
	List<Material> Items = Arrays.asList(Material.values());
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();
		
		if (itemInHand.equals(ItemManager.PickaxeDrill)) {
			int amount = 4;
			int X = player.getLocation().getBlockX();
			int Z = player.getLocation().getBlockZ();
			World world = player.getWorld();
			
			EditArea.getBlocks(X, Z, amount, world, 5);
			
		}else {
			int random_num = (int)Math.floor(Math.random() *(5-0+1)+0);
			if (random_num == 1) {
				ItemStack item = SpecialItems.get(rand.nextInt(SpecialItems.size()));
				event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), item);
			}
			else if (random_num > 1) {
				int x = rand.nextInt(Items.size());
				Material material = Items.get(x);
				
				if (material.isAir() || !material.isItem() || !material.isBlock() || material == null) {
					if(player.getInventory().getHelmet() != null) {
						String HelmetName = player.getInventory().getHelmet().getItemMeta().getDisplayName();
						if (!HelmetName.equals(ItemManager.AntiLightningHelmet.getItemMeta().getDisplayName())) {
							player.getWorld().strikeLightning(player.getLocation());
						}
					}else {
						player.getWorld().strikeLightning(player.getLocation());
					}
					
				}
				else {
					ItemStack item = new ItemStack(material);
					
					event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), item);
				}
			}
		}
	}
}
