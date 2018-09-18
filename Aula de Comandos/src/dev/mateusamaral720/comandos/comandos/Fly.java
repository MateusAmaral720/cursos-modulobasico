package dev.mateusamaral720.comandos.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.mateusamaral720.comandos.Main;

public class Fly implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("voar")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player)sender;
			if(!p.hasPermission("permissao.voar")) {
				p.sendMessage("" + Main.getPlugin().configuracao.getString("MensagemSemPermissao").replace("&", "§"));
				return true;
			}
			if(p.getAllowFlight() == true) {
				p.setAllowFlight(false);
				p.sendMessage("§cFly Desativado!");
			} else if(p.getAllowFlight() == false){
				p.setAllowFlight(true);
				p.sendMessage("§aFly Ativado!");
			}
		}
	return false;
	}
}
