package dev.mateusamaral720.cash.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import dev.mateusamaral720.cash.api.CashAPI;

public class Eventos implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!CashAPI.cash.contains("Cash." + p.getName())) {
			CashAPI.setCash(p, 0);
		} 
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(CashAPI.getCash(p) < 0) {
			CashAPI.setCash(p, 0);
		}
	}
}
