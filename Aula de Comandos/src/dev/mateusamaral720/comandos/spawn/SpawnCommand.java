package dev.mateusamaral720.comandos.spawn;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import dev.mateusamaral720.comandos.Main;

public class SpawnCommand implements CommandExecutor{
	
	public static ArrayList<Player> array = new ArrayList<>();
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if(args.length == 0) {
				if(Main.getPlugin().spawn.contains("Spawn")) {
					if(!array.contains(p)) {
						array.add(p);
						p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5*20, 1));
						new BukkitRunnable() {
							int tempo = 5;
							@Override
							public void run() {
								tempo--;
								if(array.contains(p)) {
									p.sendMessage("§aTeleportando em: " + tempo + " segundos, não se mova.");
									if(tempo == 0) {
										World world = Bukkit.getWorld(Main.getPlugin().spawn.getString("Spawn.World"));
										double x = Main.getPlugin().spawn.getDouble("Spawn.X");
										double y = Main.getPlugin().spawn.getDouble("Spawn.Y");
										double z = Main.getPlugin().spawn.getDouble("Spawn.Z");
										double yaw = Main.getPlugin().spawn.getDouble("Spawn.Yaw");
										double pitch = Main.getPlugin().spawn.getDouble("Spawn.Pitch");
										
										Location loc = new Location(world, x, y, z, (float)yaw, (float)pitch);
										p.teleport(loc);
										p.sendMessage("§aVocê foi teleportado ao spawn!");
										p.removePotionEffect(PotionEffectType.BLINDNESS);
										cancel();
									}
								} else {
									cancel();
									p.sendMessage("§cVocê se moveu, teleporte cancelado!");
									p.removePotionEffect(PotionEffectType.BLINDNESS);
								}
							}
						}.runTaskTimer(Main.getPlugin(), 1*20, 1*20);
					}
				} else {
					p.sendMessage("§cAinda nao existe nenhum spawn setado");
				}
			}
		}
		
		String prefix = "§e[Aula] » ";
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if(!p.hasPermission("permissao.setspawn")) {
				p.sendMessage("§e[Aula] » §cVocê não tem permissão!");
				return true;
			}
			
			if(args.length == 0) {
				double x = p.getLocation().getX();
				double y = p.getLocation().getY();
				double z = p.getLocation().getZ();
				double yaw = p.getLocation().getYaw();
				double pitch = p.getLocation().getPitch();
				String world = p.getLocation().getWorld().getName();
				Main.getPlugin().spawn.set("Spawn.X", x);
				Main.getPlugin().spawn.set("Spawn.Y", y);
				Main.getPlugin().spawn.set("Spawn.Z", z);
				Main.getPlugin().spawn.set("Spawn.Yaw", yaw);
				Main.getPlugin().spawn.set("Spawn.Pitch", pitch);
				Main.getPlugin().spawn.set("Spawn.World", world);
				Main.getPlugin().spawn.saveConfig();
				p.sendMessage(prefix + "§aO spawn foi setado com sucesso!");
				
			}
		}
		return false;
	}

}
