package dev.mateusamaral720.comandos.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.mateusamaral720.comandos.Main;

public class Warps implements CommandExecutor {
	public static void criarWarp(Location loc, String nome) {
		Main.getPlugin().warps.set("Warps." + nome + ".X", loc.getX());
		Main.getPlugin().warps.set("Warps." + nome + ".Y", loc.getY());
		Main.getPlugin().warps.set("Warps." + nome + ".Z", loc.getZ());
		Main.getPlugin().warps.set("Warps." + nome + ".pitch", loc.getPitch());
		Main.getPlugin().warps.set("Warps." + nome + ".Yaw", loc.getYaw());
		Main.getPlugin().warps.set("Warps." + nome + ".World", loc.getWorld().getName());
		Main.getPlugin().warps.saveConfig();

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setwarp")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cUse: /setwarp <warp>");
				return true;
			}
			String nome = args[0];
			Location loc = p.getLocation();
			if (nome.length() >= 16) {
				p.sendMessage("§cNome muito grande!");
				return true;
			}
			criarWarp(loc, nome);
			p.sendMessage("§ca warp " + nome + " foi definida.");

		}

		if (label.equalsIgnoreCase("warp")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				StringBuilder sb = new StringBuilder();
				for (String WARPLIST : Main.getPlugin().warps.getConfig().getConfigurationSection("Warps")
						.getKeys(false)) {
					sb.append("§7" + WARPLIST);
					sb.append("§f, ");
				}
				String warp = sb.toString().substring(0, sb.toString().length() - 2);
				p.sendMessage("§6Warps: §e" + warp);
				return true;
			}

			String warp = args[0];
			if (Main.getPlugin().warps.contains("Warps." + warp)) {
				if (p.hasPermission("warp." + warp)) {
					p.sendMessage("§aVocê foi teleportado a warp " + warp);
					World world = Bukkit.getWorld(Main.getPlugin().warps.getString("Warps." + warp + ".World"));
					double x = Main.getPlugin().warps.getDouble("Warps." + warp + ".X");
					double y = Main.getPlugin().warps.getDouble("Warps." + warp + ".Y");
					double z = Main.getPlugin().warps.getDouble("Warps." + warp + ".Z");
					double pitch = Main.getPlugin().warps.getDouble("Warps." + warp + ".Pitch");
					double yaw = Main.getPlugin().warps.getDouble("Warps." + warp + ".Yaw");
					Location loc = new Location(world, x, y, z, (float) yaw, (float) pitch);
					p.teleport(loc);
				} else {
					p.sendMessage("§b[Aula] » §cVocê não tem permissao para ir a esta warp");
				}
			} else {
				p.sendMessage("§b[Aula] » §cWarp Inexistente");
			}
		}

		if (cmd.getName().equals("delwarp")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cUse: /delwarp <warp>");
				return true;
			}
			String nome = args[0];
			if (Main.getPlugin().warps.contains("Warps." + args[0])) {
				Main.getPlugin().warps.set("Warps." + nome, null);
				Main.getPlugin().warps.saveConfig();
				p.sendMessage("§b[Aula] » §cVocê deletou a warp " + nome);
			} else {
				p.sendMessage("§b[Aula] » §cEsta warp nao existe");
			}
		}

		return false;

	}
}
