package dev.mateusamaral720.cash.api;

import org.bukkit.entity.Player;

import dev.mateusamaral720.cash.Main;

public class CashAPI {

	public static MTConfig cash = Main.getPlugin().cash;

	public static void setCash(Player p, int quantidade) {
		cash.set("Cash." + p.getName(), quantidade);
		cash.saveConfig();
	}

	public static int getCash(Player p) {
		return cash.getInt("Cash." + p.getName());
	}

	public static void addCash(Player p, int quantidade) {
		setCash(p, getCash(p) + quantidade);
	}

	public static void removeCash(Player p, int quantidade) {
		setCash(p, getCash(p) - quantidade);
	}

	public static boolean contains(Player p, int quantidade) {
		return getCash(p) >= quantidade;
	}
	
}
