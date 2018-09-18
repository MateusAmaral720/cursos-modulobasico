package dev.mateusamaral720.comandos.comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Build implements CommandExecutor{
	
	public static ArrayList<Player> lista = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("build")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§bApenas para jogadores!");
				return true;
			}
			
			Player p = (Player)sender;
			if(lista.contains(p)) {
				lista.remove(p);
				p.sendMessage("§aVocê pode construir!");
			} else {
				lista.add(p);
				p.sendMessage("§aVocê agora nao pode construir!");
			}
		}
		return false;
	}
	
	

}
