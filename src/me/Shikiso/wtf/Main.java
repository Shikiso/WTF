package me.Shikiso.wtf;

import org.bukkit.plugin.java.JavaPlugin;

import me.Shikiso.wtf.Blocks.LaunchBlocks;
import me.Shikiso.wtf.Blocks.ModifyOres;
import me.Shikiso.wtf.Blocks.ModifyTrees;
import me.Shikiso.wtf.Blocks.RandomDrops;
import me.Shikiso.wtf.Blocks.TntSpawn;
import me.Shikiso.wtf.GameEvents.TNT;
import me.Shikiso.wtf.Mobs.Boss.ModifyEnderDragon;
import me.Shikiso.wtf.Mobs.Boss.ModifyWither;
import me.Shikiso.wtf.Mobs.Hostile.ModifWitherSkeleton;
import me.Shikiso.wtf.Mobs.Hostile.ModifyBlazes;
import me.Shikiso.wtf.Mobs.Hostile.ModifyCreeper;
import me.Shikiso.wtf.Mobs.Hostile.ModifyGhasts;
import me.Shikiso.wtf.Mobs.Hostile.ModifyMagmaCube;
import me.Shikiso.wtf.Mobs.Hostile.ModifySilverfish;
import me.Shikiso.wtf.Mobs.Hostile.ModifySkeletons;
import me.Shikiso.wtf.Mobs.Hostile.ModifyZombie;
import me.Shikiso.wtf.Mobs.Neutral.ModifyBee;
import me.Shikiso.wtf.Mobs.Neutral.ModifyEnderman;
import me.Shikiso.wtf.Mobs.Neutral.ModifyPiglin;
import me.Shikiso.wtf.Mobs.Neutral.ModifySpiders;
import me.Shikiso.wtf.Mobs.Passive.ModifyChicken;
import me.Shikiso.wtf.Mobs.Passive.ModifyCow;
import me.Shikiso.wtf.Mobs.Passive.ModifyFish;
import me.Shikiso.wtf.Mobs.Passive.ModifyGoodAnimal;
import me.Shikiso.wtf.Mobs.Passive.ModifyHorse;
import me.Shikiso.wtf.Mobs.Passive.ModifyPigs;
import me.Shikiso.wtf.Mobs.Passive.ModifySheep;
import me.Shikiso.wtf.Mobs.Utility.ModifyIronGolem;
import me.Shikiso.wtf.Mobs.Utility.ModifySnowGolems;
import me.Shikiso.wtf.Player.DamageEvent;
import me.Shikiso.wtf.Player.RightClick;
import me.Shikiso.wtf.PluginUtil.ItemManager;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {		
		//Items
		ItemManager.init();
		
		//Events
//		getServer().getPluginManager().registerEvents(new Crafting(), this);
		getServer().getPluginManager().registerEvents(new TNT(), this);
				
		//Blocks
		getServer().getPluginManager().registerEvents(new LaunchBlocks(), this);
		getServer().getPluginManager().registerEvents(new ModifyOres(), this);
		getServer().getPluginManager().registerEvents(new ModifyTrees(), this);
		getServer().getPluginManager().registerEvents(new RandomDrops(), this);
		getServer().getPluginManager().registerEvents(new TntSpawn(), this);
		
		//Boss
		getServer().getPluginManager().registerEvents(new ModifyEnderDragon(), this);
		getServer().getPluginManager().registerEvents(new ModifyWither(), this);
		ModifyEnderDragon.init();
		
		//Hostile
		getServer().getPluginManager().registerEvents(new ModifySilverfish(), this);
		getServer().getPluginManager().registerEvents(new ModifyCreeper(), this);
		getServer().getPluginManager().registerEvents(new ModifySkeletons(), this);
		getServer().getPluginManager().registerEvents(new ModifyZombie(), this);
		getServer().getPluginManager().registerEvents(new ModifyBlazes(), this);
		getServer().getPluginManager().registerEvents(new ModifyGhasts(), this);
		getServer().getPluginManager().registerEvents(new ModifWitherSkeleton(), this);
		getServer().getPluginManager().registerEvents(new ModifyMagmaCube(), this);
		
		//Neutral
		getServer().getPluginManager().registerEvents(new ModifySpiders(), this);
		getServer().getPluginManager().registerEvents(new ModifyEnderman(), this);
		getServer().getPluginManager().registerEvents(new ModifyPiglin(), this);
		getServer().getPluginManager().registerEvents(new ModifyBee(), this);
		
		//Passive
		getServer().getPluginManager().registerEvents(new ModifyHorse(), this);
		getServer().getPluginManager().registerEvents(new ModifyPigs(), this);
		getServer().getPluginManager().registerEvents(new ModifyChicken(), this);
		getServer().getPluginManager().registerEvents(new ModifyCow(), this);
		getServer().getPluginManager().registerEvents(new ModifySheep(), this);
		getServer().getPluginManager().registerEvents(new ModifyFish(), this);
		getServer().getPluginManager().registerEvents(new ModifyGoodAnimal(), this);
		
		//Utility
		getServer().getPluginManager().registerEvents(new ModifyIronGolem(), this);
		getServer().getPluginManager().registerEvents(new ModifySnowGolems(), this);
		
		//Players
		getServer().getPluginManager().registerEvents(new DamageEvent(), this);
		getServer().getPluginManager().registerEvents(new RightClick(), this);
		
		System.out.println("[WTF] Loaded WTF");
	}
}
