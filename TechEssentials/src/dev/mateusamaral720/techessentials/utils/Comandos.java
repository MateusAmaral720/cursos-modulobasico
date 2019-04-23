package dev.mateusamaral720.techessentials.utils;

import org.bukkit.command.CommandExecutor;

import dev.mateusamaral720.techessentials.Main;
import dev.mateusamaral720.techessentials.comandos.BroadCast;

public class Comandos {
	
	public static void novoComando(String comando, CommandExecutor classe) {
		Main.getPlugin().getCommand(comando).setExecutor(classe);
	}
	
	public static void carregar() {
		novoComando("broadcast", new BroadCast());
	}

}
