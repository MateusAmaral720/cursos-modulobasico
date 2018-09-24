package dev.mateusamaral720.cash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.cash.api.MTConfig;
import dev.mateusamaral720.cash.comandos.CashCommand;
import dev.mateusamaral720.cash.eventos.Eventos;

public class Main extends JavaPlugin{
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
	
	public MTConfig cash = new MTConfig(this, "Cash.yml");
	
	public void onEnable() {
		cash.saveDefaultConfig();
		getCommand("cash").setExecutor(new CashCommand());
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}
	
	
	

}
