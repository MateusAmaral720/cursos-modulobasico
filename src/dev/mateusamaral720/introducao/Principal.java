package dev.mateusamaral720.introducao;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.introducao.comandos.HelloWorld;

public class Principal extends JavaPlugin{
	
	public static Principal retornarPlugin() {
		return getPlugin(Principal.class);
	}
	
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage("o plugin foi CARREGADO");
	}
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("o plugin foi HABILITADO");
		getCommand("helloworld").setExecutor(new HelloWorld());
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("o plugin foi DESABILITADO E DESCARREGADO");
	}

}
