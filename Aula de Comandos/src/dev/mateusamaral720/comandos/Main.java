package dev.mateusamaral720.comandos;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.comandos.api.MTConfig;
import dev.mateusamaral720.comandos.comandos.Build;
import dev.mateusamaral720.comandos.comandos.Fly;
import dev.mateusamaral720.comandos.comandos.Gamemode;
import dev.mateusamaral720.comandos.comandos.Heal;
import dev.mateusamaral720.comandos.comandos.Warps;

public class Main extends JavaPlugin implements Listener{
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(Build.lista.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(Build.lista.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
	

	public static Main getPlugin() {
		return JavaPlugin.getPlugin(Main.class);
	}
	
	public MTConfig warps = new MTConfig(this, "Warps.yml");
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§bComandos carregados!");
		Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("curar").setExecutor(new Heal());
		getCommand("fome").setExecutor(new Heal());
		getCommand("voar").setExecutor(new Fly());
		getCommand("build").setExecutor(new Build());
		getCommand("setwarp").setExecutor(new Warps());
		getCommand("warp").setExecutor(new Warps());
		getCommand("delwarp").setExecutor(new Warps());
		getCommand("gm").setExecutor(new Gamemode());
	}
	
	
	

}
