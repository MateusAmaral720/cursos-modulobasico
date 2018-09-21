package dev.mateusamaral720.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Bloco implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
			Block bloco = e.getBlock();
			if(PermissionsEx.getUser(p).getGroups()[0].getName().equalsIgnoreCase("vip")) {
				// Cancela o evento, para nao dropar itens nem deixar o bloco ser quebrado
				e.setCancelled(true);
				for(ItemStack dropes : bloco.getDrops()) {
				bloco.getWorld().dropItemNaturally(bloco.getLocation(), dropes);
				// peguei a localidade do bloco e dropei um item naturalmente
				}
				// for Pegando os drops do bloco do evento, e transformando em itemstack
				bloco.setType(Material.COBBLESTONE);
				// seta o material do bloco assim que ele é quebrado, ou seja, quando quebrei, ele virou cobblestone
				ActionBarAPI.sendActionBar(p, "§aVocê Recebeu §eR$1000 §apor quebrar este bloco.", 3*20);
				Money.add(p, 1000.0);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						// CODIGO
						bloco.setType(Material.DIAMOND_ORE);
						p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1F, 1F);
						}
				}.runTaskLater(Main.getPlugin(), 10*20);
				
			} else {
				// Cancela o evento, para nao dropar itens nem deixar o bloco ser quebrado
				e.setCancelled(true);
				for(ItemStack dropes : bloco.getDrops()) {
				bloco.getWorld().dropItemNaturally(bloco.getLocation(), dropes);
				}
				bloco.setType(Material.COBBLESTONE);
				// seta o material do bloco assim que ele é quebrado, ou seja, quando quebrei, ele virou cobblestone
				ActionBarAPI.sendActionBar(p, "§aVocê Recebeu §eR$500 §apor quebrar este bloco.", 3*20);
				Money.add(p, 500.0);
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						// CODIGO
						bloco.setType(Material.DIAMOND_ORE);
						p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1F, 1F);
						}
				}.runTaskLater(Main.getPlugin(), 10*20);
			}
			
			
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
