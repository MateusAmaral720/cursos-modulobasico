package dev.mateusamaral720.comandos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("curar")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cComando apenas para jogadores!");
				return true;
			}
			
			Player p = (Player)sender;
			if(p.hasPermission("permissao.curar")) {
				p.setHealth(20);
				p.sendMessage("§aSua vida foi restaurada!");
				return true;
			} 
			p.sendMessage("§cVocê não possui permissao.");
		}
		if(cmd.getName().equalsIgnoreCase("fome")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cComando apenas para jogadores!");
				return true;
			}
			
			Player p = (Player)sender;
			if(p.hasPermission("permissao.fome")) {
				p.setFoodLevel(20);
				p.sendMessage("§aSua fome foi restaurada!");
				return true;
			} 
			p.sendMessage("§cVocê não possui permissao.");
		}
		return false;
	}
}
