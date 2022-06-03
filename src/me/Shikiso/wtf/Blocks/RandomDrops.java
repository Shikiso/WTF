package me.Shikiso.wtf.Blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.Shikiso.wtf.PluginUtil.EditArea;
import me.Shikiso.wtf.PluginUtil.ItemManager;

public class RandomDrops implements Listener {
	Random rand = new Random();
	
	List<Material> Ores = Arrays.asList(Material.DIAMOND_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.NETHER_GOLD_ORE,
			Material.COAL_ORE, Material.EMERALD_ORE, Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.ANCIENT_DEBRIS);
	
	List<ItemStack> SpecialItems = Arrays.asList(ItemManager.ImmortalBoots, ItemManager.OPSword, ItemManager.PickaxeDrill,
			ItemManager.YeetStick, ItemManager.LaunchPad);
	
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
			int random_num = (int)Math.floor(Math.random() *(4-0+1)+0);
			if (random_num == 1) {
				Material randomElement = Ores.get(rand.nextInt(Ores.size()));
				ItemStack item = new ItemStack(randomElement);
				
				event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), item);
			}
			else if (random_num == 2) {
				ItemStack item = SpecialItems.get(rand.nextInt(SpecialItems.size()));
				
				event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), item);
			}
			else if (random_num == 3) {
				Material randomElement = Items.get(rand.nextInt(Items.size()));
				ItemStack item = new ItemStack(randomElement);
				
				event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), item);
			}
		}
	}
}
