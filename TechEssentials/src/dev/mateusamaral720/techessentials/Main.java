package dev.mateusamaral720.techessentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.techessentials.utils.Comandos;

public class Main extends JavaPlugin{
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§bTechEssentials - Iniciado");
		try {
			Comandos.carregar();
			Bukkit.getConsoleSender().sendMessage("§bTechMC §7» §fComandos carregados com sucesso.");
		} catch(Exception e) {
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§bTechMC §7» §Nao foi possivel carregar os comandos, confira o erro");
		}
		
	}
	
	
	
	

}
