package dev.mateusamaral720.eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void quandoJogadorEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);

		if (p.isOp() || p.hasPermission("entrada.mensagem")) {
			Bukkit.broadcastMessage("§a[OP] O Jogador §e" + p.getName() + " Entrou no servidor");
		} else {
			Bukkit.broadcastMessage("§c[SEM OP] O Jogador §e" + p.getName() + " Entrou no servidor");
		}

	}

	@EventHandler
	public void onServerPing(ServerListPingEvent e) {
		e.setMaxPlayers(50);
		e.setMotd("§f§l• §aServidor Online, venha jogar! \n§f§l• §cVersão: 1.8.x"); 
	}

	
	@EventHandler
	public void quandoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		e.setQuitMessage(null);

		if (p.isOp() || p.hasPermission("saida.mensagem")) {
			Bukkit.broadcastMessage("§a[OP] O Jogador §e" + p.getName() + " Saiu do servidor");
			// [Master] MateusAmaral720 Entrou
		} else {
			Bukkit.broadcastMessage("§c[SEM OP] O Jogador §e" + p.getName() + " Saiu do servidor");
			// [+] MateusAmaral720
		}

	}

}
