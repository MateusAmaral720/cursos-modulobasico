package dev.mateusamaral720.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Bloco implements Listener{
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
			p.sendMessage("§eVocÊ quebrou um bloco de diamante!");
			e.setCancelled(true);
			e.getBlock().setType(Material.QUARTZ_BLOCK);
		} else {
			p.sendMessage("§bVocê quebrou o bloco: §e" + e.getBlock().getType());
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(e.getBlockPlaced().getType().equals(Material.DIAMOND_BLOCK)) {
			p.sendMessage("§eVocÊ colocou um bloco de diamante!");
		} else {
			p.sendMessage("§bVocê colocou o bloco: §e" + e.getBlockPlaced().getType());
		}
	}

}
