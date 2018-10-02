package dev.mateusamaral720.caixas;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.caixas.caixaAPI.CaixaAPI;

public class Main extends JavaPlugin implements CommandExecutor{
	
	public static Main getPlugin() {
		return Main.getPlugin(Main.class);
	}
	
	public void onEnable() {
		CaixaAPI.setItensBasico();
		CaixaAPI.setItensMistico();
		CaixaAPI.setItensEpico();
		CaixaAPI.setItensDivino();
		getCommand("caixa").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("caixa")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player)sender;
			if(args.length == 0) {
				p.sendMessage("§cUse: /caixa <caixa>");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("basica")) {
				CaixaAPI.abrirCaixaBasica(p);
			}
			if(args[0].equalsIgnoreCase("mistica")) {
				CaixaAPI.abrirCaixaMistica(p);
			}
			if(args[0].equalsIgnoreCase("epica")) {
				CaixaAPI.abrirCaixaEpica(p);
			}
			if(args[0].equalsIgnoreCase("divina")) {
				CaixaAPI.abrirCaixaDivina(p);
			}
		}
		return false;
	}
	
	

}
