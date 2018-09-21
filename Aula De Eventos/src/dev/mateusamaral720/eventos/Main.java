package dev.mateusamaral720.eventos;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
	
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage("Plugin CARREGADO");
	}
	
	public void onEnable() {
		Money.register();
		Bukkit.getConsoleSender().sendMessage("Plugin HABILITADO");
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new Bloco(), this);
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin DESABILITADO");
	}

}
