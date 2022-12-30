package me.Shikiso.wtf.PluginUtil;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
	public static ItemStack OPSword;
	public static ItemStack ImmortalBoots;
	public static ItemStack YeetStick;
	public static ItemStack PickaxeDrill;
	public static ItemStack LaunchPad;
	public static ItemStack FlyingFeather;
	public static ItemStack AntiLightningHelmet;
	public static ItemStack AntiExplosionChestplate;
	
	public static void init() {
		createOPSword();
		createImmortalBoots();
		createYeetStick();
		createPickaxeDrill();
		createLaunchPad();
		createFlyingFeather();
		createAntiLightningHelmet();
		createAntiExplosionChestplate();
	}
	
	public static void createOPSword() {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("HOLY SHIT!!!!");
		List<String> lore = new ArrayList<>();
		lore.add("This shouldn't exist but im tired and bored");
		lore.add("Go bully someone with it");
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
		OPSword = item;
	}
	
	public static void createImmortalBoots() {
		ItemStack item = new ItemStack(Material.GOLDEN_BOOTS, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Immortal Boots");
		List<String> lore = new ArrayList<>();
		lore.add("Everytime these save your life");
		lore.add("another life is take as equal cost");
		meta.setLore(lore);
		item.setItemMeta(meta);
		ImmortalBoots = item;
	}
	
	public static void createYeetStick() {
		ItemStack item = new ItemStack(Material.STICK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Yeet Stick");
		List<String> lore = new ArrayList<>();
		lore.add("Go make someone risen");
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1000);
		YeetStick = item;
	}
	
	public static void createPickaxeDrill() {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Pickaxe");
		List<String> lore = new ArrayList<>();
		lore.add("IDK if this is good or bad you decide");
		meta.setLore(lore);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
		PickaxeDrill = item;
	}
	
	public static void createLaunchPad() {
		ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Launch Pad");
		List<String> lore = new ArrayList<>();
		lore.add("Punch something to launch into the sky");
		meta.setLore(lore);
		item.setItemMeta(meta);
		LaunchPad = item;
	}
	
	public static void createFlyingFeather() {
		ItemStack item = new ItemStack(Material.FEATHER, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Flying Feather");
		List<String> lore = new ArrayList<>();
		lore.add("Right click to be able to fly");
		meta.setLore(lore);
		item.setItemMeta(meta);
		FlyingFeather = item;
	}
	
	public static void createAntiLightningHelmet() {
		ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Anti Lightning Helmet");
		item.setItemMeta(meta);
		AntiLightningHelmet = item;
	}
	
	public static void createAntiExplosionChestplate() {
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Anti Explosion Chestplate");
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1000000);
		AntiExplosionChestplate = item;
	}
}

