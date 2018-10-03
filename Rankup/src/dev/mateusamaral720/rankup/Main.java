package dev.mateusamaral720.rankup;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mateusamaral720.rankup.api.ActionBarAPI;
import dev.mateusamaral720.rankup.api.MTConfig;
import dev.mateusamaral720.rankup.api.Money;
import dev.mateusamaral720.rankup.utils.RankUpType;

public class Main extends JavaPlugin implements CommandExecutor,Listener {

	public static Main getPlugin() {
		return getPlugin(Main.class);
	}

	public MTConfig rank = new MTConfig(this, "Rank.yml");

	public void onEnable() {
		rank.saveDefaultConfig();
		Money.register();
		getCommand("rankup").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!RankUpType.containsRank(p.getName())) {
			RankUpType.setRank(p.getName(), RankUpType.Um);
		} else {
			RankUpType.setRank(p.getName(), RankUpType.rank.get(p.getName()));
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rankup")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				if (RankUpType.rank.get(p.getName()) == RankUpType.Um) {
					if(RankUpType.rank.get(p.getName()) != RankUpType.Um) {
						p.sendMessage("§cVocê precisa ser do rank um, para upar ao rank 2");
						return true;
					}
					if (Money.contains(p, 1000.0)) {
						RankUpType.setRank(p.getName(), RankUpType.dois);
						p.sendMessage("§aVocê upou para o rank: §r" + RankUpType.getRankPrefix(p.getName()));
						Bukkit.broadcastMessage("§aO Jogador §e" + p.getName() + " §aUpou para o rank: §r"
								+ RankUpType.getRankPrefix(p.getName()));
					} else {
						ActionBarAPI.sendActionBar(p, "§aVocê não possui dinheiro suficiente para upar de rank!",
								5 * 20);
					}
					
				} else

				if (RankUpType.rank.get(p.getName()) == RankUpType.dois) {
					if(RankUpType.rank.get(p.getName()) != RankUpType.dois) {
						p.sendMessage("§cVocê precisa ser do rank dois, para upar ao rank 3");
						return true;
					}
					if (Money.contains(p, 2000.0)) {
						RankUpType.setRank(p.getName(), RankUpType.tres);
						p.sendMessage("§aVocê upou para o rank: §r" + RankUpType.getRankPrefix(p.getName()));
						Bukkit.broadcastMessage("§aO Jogador §e" + p.getName() + " §aUpou para o rank: §r"
								+ RankUpType.getRankPrefix(p.getName()));
					} else {
						ActionBarAPI.sendActionBar(p, "§aVocê não possui dinheiro suficiente para upar de rank!",
								5 * 20);
					}
				} else

				if (RankUpType.rank.get(p.getName()) == RankUpType.tres) {
					p.sendMessage("§cVocê ja está no rank final!");
				} else

				if (RankUpType.rank.get(p.getName()) == null) {
					p.sendMessage("§cVoce nao possui um rank!");
				}

			}
		}
		return false;
	}

}
