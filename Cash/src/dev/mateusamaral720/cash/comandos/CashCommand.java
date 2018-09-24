package dev.mateusamaral720.cash.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.mateusamaral720.cash.api.CashAPI;

public class CashCommand extends CashAPI implements CommandExecutor{
	
	public static String prefix = "§e[Cash] »";
	
	public static ArrayList<Player> delay = new ArrayList<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(!(sender instanceof Player)) {
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("cash")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(delay.contains(p)) {
					
				}
				if(cash.contains("Cash." + p.getName())) {
					p.sendMessage(prefix + "§bSeu Saldo: §e" + getCash(p));
				} else {
					p.sendMessage("§cSeu saldo não foi encontrado em nossa config!");
				}
				return true;
			}
			
			if(args[0].equalsIgnoreCase("ver")) {
				Player t = Bukkit.getPlayer(args[1]);
				if(t == null) {
					p.sendMessage("§cJogador offline!");
				return true;
				}
				if(cash.contains("Cash." + t.getName())) {
					p.sendMessage("§aSaldo do jogador " + t.getName() + ": §e" + getCash(t));
				} else {
					p.sendMessage("§cNao foi possivel encontrar o jogador em nossa base de dados");
				}
			}
			
			if(!p.hasPermission("permissao.cashcommands")) {
				p.sendMessage("§cSem permissao.");
				return true;
			}
			if(args[0].equalsIgnoreCase("set")) {
				
				Player t = Bukkit.getPlayer(args[1]);
				
				int valor;
				
				try {
					valor = Integer.parseInt(args[2]);
				} catch(NumberFormatException e) {
					p.sendMessage("§cUse apenas numeros!");
					return true;
				}
				
				p.sendMessage("§cVocê setou o cash do jogador §e" + t.getName() + " §cPara: §e" + valor);
				t.sendMessage("§cSeu cash foi setado para: §e" + valor);
				
				CashAPI.setCash(t, valor);
			}
			
			
			if(args[0].equalsIgnoreCase("add")) {
				
				Player t = Bukkit.getPlayer(args[1]);
				
				int valor;
				
				try {
					valor = Integer.parseInt(args[2]);
				} catch(NumberFormatException e) {
					p.sendMessage("§cUse apenas numeros!");
					return true;
				}
				
				p.sendMessage("§cVocê adicionou §e" + valor + " §cDe cash para o jogador §e" + t.getName()	);
				t.sendMessage("§cForam adicionados em sua conta, o cash com valor de: §e" + valor);
				
				CashAPI.addCash(t, valor);
			}
			
			
			if(args[0].equalsIgnoreCase("remove")) {
				
				Player t = Bukkit.getPlayer(args[1]);
				
				int valor;
				
				try {
					valor = Integer.parseInt(args[2]);
				} catch(NumberFormatException e) {
					p.sendMessage("§cUse apenas numeros!");
					return true;
				}
				
				p.sendMessage("§cVocê removeu §e" + valor + " §cDe cash do jogador §e" + t.getName()	);
				t.sendMessage("§cForam removidos de sua conta, o cash com valor de: §e" + valor);
				
				CashAPI.removeCash(t, valor);
			}
		}
		return false;
	}

}
