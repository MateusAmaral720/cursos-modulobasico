package dev.mateusamaral720.comandos.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import dev.mateusamaral720.comandos.Main;

public class SpawnEvents implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(SpawnCommand.array.contains(p)) {
			SpawnCommand.array.remove(p);
		} 
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Main.getPlugin().spawn.contains("Spawn")) {
		Player p = e.getPlayer();
		
		World world = Bukkit.getWorld(Main.getPlugin().spawn.getString("Spawn.World"));
		double x = Main.getPlugin().spawn.getDouble("Spawn.X");
		double y = Main.getPlugin().spawn.getDouble("Spawn.Y");
		double z = Main.getPlugin().spawn.getDouble("Spawn.Z");
		double yaw = Main.getPlugin().spawn.getDouble("Spawn.Yaw");
		double pitch = Main.getPlugin().spawn.getDouble("Spawn.Pitch");
		
		Location loc = new Location(world, x, y, z, (float)yaw, (float)pitch);
		p.teleport(loc);
	}
	}
}
