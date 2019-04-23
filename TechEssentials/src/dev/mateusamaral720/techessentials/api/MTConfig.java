package dev.mateusamaral720.techessentials.api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MTConfig {
	private JavaPlugin plugin;
	private String name;
	private File file;
	private YamlConfiguration config;

	public MTConfig(final JavaPlugin plugin, final String nome) {
		this.plugin = plugin;
		this.setName(nome);
		this.reloadConfig();
	}

	public JavaPlugin getPlugin() {
		return this.plugin;
	}

	public void setPlugin(final JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public File getFile() {
		return this.file;
	}

	public YamlConfiguration getConfig() {
		return this.config;
	}

	public void saveConfig() {
		try {
			this.getConfig().save(this.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveDefault() {
		this.getConfig().options().copyDefaults(true);
	}

	public void saveDefaultConfig() {
		this.getPlugin().saveResource(this.getName(), false);
	}

	public void reloadConfig() {
		this.file = new File(this.getPlugin().getDataFolder(), this.getName());
		this.config = YamlConfiguration.loadConfiguration(this.getFile());
	}

	public void deleteConfig() {
		this.getFile().delete();
	}

	public boolean existeConfig() {
		return this.getFile().exists();
	}

	public String getString(final String path) {
		return this.getConfig().getString(path);
	}

	public int getInt(final String path) {
		return this.getConfig().getInt(path);
	}

	public boolean getBoolean(final String path) {
		return this.getConfig().getBoolean(path);
	}

	public double getDouble(final String path) {
		return this.getConfig().getDouble(path);
	}

	public List<?> getList(final String path) {
		return (List<?>) this.getConfig().getList(path);
	}

	public boolean contains(final String path) {
		return this.getConfig().contains(path);
	}

	public void set(final String path, final Object value) {
		this.getConfig().set(path, value);
	}
}
