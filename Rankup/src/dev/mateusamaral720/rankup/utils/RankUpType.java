package dev.mateusamaral720.rankup.utils;

import java.util.HashMap;

import dev.mateusamaral720.rankup.Main;

public enum RankUpType {

	Um, dois, tres;

	public static HashMap<String, RankUpType> rank = new HashMap<>();

	public static void setRank(String name, RankUpType type) {
		if (rank.containsKey(name)) {
			rank.remove(name);
		}
		Main.getPlugin().rank.set("Rank." + name, type.toString());
		Main.getPlugin().rank.saveConfig();
		rank.put(name, type);
	}
	

	public static boolean containsRank(String name) {
		return rank.containsKey(name);
	} 

	public static boolean containsRank(String name, RankUpType type) {
		if (containsRank(name)) {
			if (rank.get(name).equals(type)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String getRankPrefix(String name) {
		if(rank.get(name).equals(Um)) {
			return "§b[Um]";
		}
		if(rank.get(name).equals(dois)) {
			return "§a[Dois]";
		}
		if(rank.get(name).equals(tres)) {
			return "§b[Tres]";
		}

		return null;
	}

	public static void removeRank(String name) {
		if (containsRank(name)) {
			rank.remove(name);
			Main.getPlugin().rank.set("Rank." + name, null);
			Main.getPlugin().rank.saveConfig();
		}
	}

}