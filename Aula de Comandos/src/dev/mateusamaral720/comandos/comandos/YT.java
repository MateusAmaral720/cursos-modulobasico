package dev.mateusamaral720.comandos.comandos;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.mateusamaral720.comandos.Main;


public class YT implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("youtuber")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cComando bloqueado via console");
				return true;
			}
			
			Player p = (Player) sender;
			Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§3Requisistos YT");
			ItemStack miniyt = new ItemStack(Material.PAPER);
			List<String> listaconfig = Main.getPlugin().warps.getConfig().getStringList("Lista");
			ItemMeta miniytmeta = miniyt.getItemMeta();
			miniytmeta.setDisplayName("§cMiniYT");
			miniytmeta.setLore(listaconfig);
				
				miniyt.setItemMeta(miniytmeta);
				inv.setItem(0, miniyt);
				p.openInventory(inv);
			
		}
		return false;
	}

}
