package dev.mateusamaral720.introducao.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloWorld implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		
		if(cmd.getName().equals("helloworld")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("Comando disponivel apenas para jogadores!");
				return true;
			}
			Player p = (Player)sender;
			p.sendMessage("Hello World, este comando funcionou!");
		}
		return false;
	}
	
	

}
