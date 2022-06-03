package me.Shikiso.wtf.Blocks;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ModifyGeneration implements Listener {
	
	public void changeBlocks(Chunk c) {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 127; y++) {
				for (int z = 0; z < 16; z++) {
					Block block = c.getBlock(x, y, z);
					if (!block.getType().equals(Material.AIR) || !block.getType().equals(Material.VOID_AIR)) {
						if (block.getType().equals(Material.DIRT)) {
							block.setType(Material.ACACIA_WOOD);
						}
					}
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onChunkLoad(ChunkLoadEvent e) {
		changeBlocks(e.getChunk());
	}
	
	public void changeLoadedChunks() {
		for (World w : Bukkit.getWorlds()){
			for (Chunk c : w.getLoadedChunks()) {
				changeBlocks(c);
			}
		}
	}

}
