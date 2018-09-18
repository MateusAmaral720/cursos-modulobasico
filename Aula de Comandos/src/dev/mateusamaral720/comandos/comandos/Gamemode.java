package dev.mateusamaral720.comandos.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cComando Bloqueado via console.");
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cVocê deve utilizar /gamemode <tipo>");
				return true;
			}
			if (p.hasPermission("permissao.gamemode")) {
				if(args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§bVocê alterou seu gamemode para criativo!");
				}
				if (args[0].equalsIgnoreCase("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§bVocê alterou seu gamemode para survival!");
				}
				return true;
				}
				
				if(args.length == 2) {
					Player t = Bukkit.getPlayerExact(args[1]);
					if (args[0].equalsIgnoreCase("1")) {
						if(t == null) {
							p.sendMessage("§cJogador Offline");
							return true;
						}
						t.setGameMode(GameMode.CREATIVE);
						t.sendMessage("§bseu gamemode foi alterado para criativo!");
					}
					if (args[0].equalsIgnoreCase("0")) {
						t.setGameMode(GameMode.SURVIVAL);
						t.sendMessage("§bseu gamemode foi alterado  criativo!");
					}
				}
				
				} 
		}
		return false;
	}

}
