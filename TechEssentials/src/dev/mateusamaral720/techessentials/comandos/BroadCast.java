package dev.mateusamaral720.techessentials.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.mateusamaral720.techessentials.api.TitleAPI;

public class BroadCast implements CommandExecutor {

	public static String getMensagem(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i] + " ");
		}
		return sb.toString();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("broadcast")) {
			CommandSender p = sender;
			if (!sender.hasPermission("techessentials.broadcast")) {
				p.sendMessage("§bTechMC §7» §fVocê não possui permissão para utilizar este comando.");
				return true;
			}
			
			if(args.length == 0) {
				p.sendMessage("§bTechMC §7» §fUse: /broadcast (chat, title)");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("chat")) {
				if(args.length < 2) {
					p.sendMessage("§bTechMC §7» §fUse: /broadcast chat <mensagem>");
					return true;
				}
				Bukkit.broadcastMessage(getMensagem(args).replace("&", "§"));
			}
			
			if(args[0].equalsIgnoreCase("title")) {
				if(args.length < 2) {
					p.sendMessage("§bTechMC §7» §fUse: /broadcast title <Titulo\nSubtitulo>");
					return true;
				}
				String titulo = getMensagem(args).split("\n")[0];
				String subtitulo = getMensagem(args).split("\n")[1];
				Bukkit.getOnlinePlayers().forEach(s -> TitleAPI.sendTitle(s, 1*20, 3*20, 1*20, titulo.replace("&", "§"), subtitulo.replace("&", "§")));
			}
		}
		return false;
	}

}
