package dev.mateusamaral720.caixas.caixaAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import dev.mateusamaral720.caixas.Main;

public class CaixaAPI {

	
	public static List<ItemStack> itembasico = new ArrayList<>();
	public static List<ItemStack> itemmistico = new ArrayList<>();
	public static List<ItemStack> itemepico = new ArrayList<>();
	public static List<ItemStack> itemdivino = new ArrayList<>();

	public static void setItensBasico() {
		List<Enchantment> encantosarmadura = new ArrayList<>();
		List<Enchantment> encantosespada = new ArrayList<>();
		List<Enchantment> encantospicareta = new ArrayList<>();
		List<Enchantment> encantospicaretasilk = new ArrayList<>();
		List<Enchantment> encantosmachado = new ArrayList<>();
		List<Enchantment> encantospa = new ArrayList<>();
		encantospicaretasilk.add(Enchantment.DIG_SPEED);
		encantospicaretasilk.add(Enchantment.DURABILITY);
		encantospicaretasilk.add(Enchantment.SILK_TOUCH);
		encantosmachado.add(Enchantment.DIG_SPEED);
		encantosmachado.add(Enchantment.DURABILITY);
		encantosmachado.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantospicareta.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.DURABILITY);
		encantospicareta.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantosespada.add(Enchantment.DAMAGE_ALL);
		encantosespada.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.SILK_TOUCH);
		encantospa.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.DIG_SPEED);
		encantosespada.add(Enchantment.LOOT_BONUS_MOBS);
		encantosarmadura.add(Enchantment.PROTECTION_ENVIRONMENTAL);
		encantosarmadura.add(Enchantment.DURABILITY);
		itembasico.add(Criar.add(Material.GOLDEN_APPLE, 16, 1));
		itembasico
				.add(Criar.add(Material.DIAMOND_HELMET, "§bCapacete de Diamante - Caixa Basica", encantosarmadura, 4));
		itembasico.add(
				Criar.add(Material.DIAMOND_CHESTPLATE, "§bPeitoral de Diamante - Caixa Basica", encantosarmadura, 4));
		itembasico.add(Criar.add(Material.DIAMOND_LEGGINGS, "§bCalça de Diamante - Caixa Basica", encantosarmadura, 4));
		itembasico.add(Criar.add(Material.DIAMOND_BOOTS, "§bBotas de Diamante - Caixa Basica", encantosarmadura, 4));
		itembasico.add(Criar.add(Material.DIAMOND_SWORD, "§bEspada De Diamante - Caixa Basica", encantosespada, 4));
		itembasico
				.add(Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Basica", encantospicareta, 4));
		itembasico.add(Criar.add(Material.DIAMOND_AXE, "§bMachado De Diamante - Caixa Basica", encantosmachado, 4));
		itembasico.add(Criar.add(Material.DIAMOND_SPADE, "§bPá De Diamante - Caixa Basica", encantospa, 4));
		itembasico.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Basica", encantospicaretasilk, 4));
	}

	public static void setItensMistico() {
		List<Enchantment> encantosarmadura = new ArrayList<>();
		List<Enchantment> encantosespada = new ArrayList<>();
		List<Enchantment> encantospicareta = new ArrayList<>();
		List<Enchantment> encantospicaretasilk = new ArrayList<>();
		List<Enchantment> encantosmachado = new ArrayList<>();
		List<Enchantment> encantospa = new ArrayList<>();
		encantospicaretasilk.add(Enchantment.DIG_SPEED);
		encantospicaretasilk.add(Enchantment.DURABILITY);
		encantospicaretasilk.add(Enchantment.SILK_TOUCH);
		encantosmachado.add(Enchantment.DIG_SPEED);
		encantosmachado.add(Enchantment.DURABILITY);
		encantosmachado.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantospa.add(Enchantment.SILK_TOUCH);
		encantospa.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.DURABILITY);
		encantospicareta.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantosespada.add(Enchantment.DAMAGE_ALL);
		encantosespada.add(Enchantment.DURABILITY);
		encantosespada.add(Enchantment.LOOT_BONUS_MOBS);
		encantosarmadura.add(Enchantment.PROTECTION_ENVIRONMENTAL);
		encantosarmadura.add(Enchantment.DURABILITY);

		itemmistico
				.add(Criar.add(Material.DIAMOND_HELMET, "§bCapacete de Diamante - Caixa Mistica", encantosarmadura, 6));
		itemmistico.add(
				Criar.add(Material.DIAMOND_CHESTPLATE, "§bPeitoral de Diamante - Caixa Mistica", encantosarmadura, 6));
		itemmistico
				.add(Criar.add(Material.DIAMOND_LEGGINGS, "§bCalça de Diamante - Caixa Mistica", encantosarmadura, 6));
		itemmistico.add(Criar.add(Material.DIAMOND_BOOTS, "§bBotas de Diamante - Caixa Mistica", encantosarmadura, 6));
		itemmistico.add(Criar.add(Material.DIAMOND_SWORD, "§bEspada De Diamante - Caixa Mistica", encantosespada, 6));
		itemmistico.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Mistica", encantospicareta, 6));
		itemmistico.add(Criar.add(Material.DIAMOND_AXE, "§bMachado De Diamante - Caixa Mistica", encantosmachado, 6));
		itemmistico.add(Criar.add(Material.DIAMOND_SPADE, "§bPá De Diamante - Caixa Mistica", encantospa, 6));
		itemmistico.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Mistica", encantospicaretasilk, 6));
		itemmistico.add(Criar.add(Material.GOLDEN_APPLE, 32, 1));

	}

	public static void setItensEpico() {
		List<Enchantment> encantosarmadura = new ArrayList<>();
		List<Enchantment> encantosespada = new ArrayList<>();
		List<Enchantment> encantospicareta = new ArrayList<>();
		List<Enchantment> encantospicaretasilk = new ArrayList<>();
		List<Enchantment> encantosmachado = new ArrayList<>();
		List<Enchantment> encantospa = new ArrayList<>();
		encantospicaretasilk.add(Enchantment.DIG_SPEED);
		encantospicaretasilk.add(Enchantment.DURABILITY);
		encantospicaretasilk.add(Enchantment.SILK_TOUCH);
		encantosmachado.add(Enchantment.DIG_SPEED);
		encantosmachado.add(Enchantment.DURABILITY);
		encantosmachado.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantospicareta.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.SILK_TOUCH);
		encantospa.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantosespada.add(Enchantment.DAMAGE_ALL);
		encantosespada.add(Enchantment.DURABILITY);
		encantosespada.add(Enchantment.LOOT_BONUS_MOBS);
		encantosarmadura.add(Enchantment.PROTECTION_ENVIRONMENTAL);
		encantosarmadura.add(Enchantment.DURABILITY);
		itemepico.add(Criar.add(Material.GOLDEN_APPLE, 8, 1));
		itemepico.add(Criar.add(Material.DIAMOND_HELMET, "§bCapacete de Diamante - Caixa Epica", encantosarmadura, 8));
		itemepico.add(
				Criar.add(Material.DIAMOND_CHESTPLATE, "§bPeitoral de Diamante - Caixa Epica", encantosarmadura, 8));
		itemepico.add(Criar.add(Material.DIAMOND_LEGGINGS, "§bCalça de Diamante - Caixa Epica", encantosarmadura, 8));
		itemepico.add(Criar.add(Material.DIAMOND_BOOTS, "§bBotas de Diamante - Caixa Epica", encantosarmadura, 8));
		itemepico.add(Criar.add(Material.DIAMOND_SWORD, "§bEspada De Diamante - Caixa Epica", encantosespada, 8));
		itemepico.add(Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Epica", encantospicareta, 8));
		itemepico.add(Criar.add(Material.DIAMOND_AXE, "§bMachado De Diamante - Caixa Epica", encantosmachado, 8));
		itemepico.add(Criar.add(Material.DIAMOND_SPADE, "§bPá De Diamante - Caixa Epica", encantospa, 8));
		itemepico.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Epica", encantospicaretasilk, 8));

	}

	public static void setItensDivino() {

		List<Enchantment> encantosarmadura = new ArrayList<>();
		List<Enchantment> encantosespada = new ArrayList<>();
		List<Enchantment> encantospicareta = new ArrayList<>();
		List<Enchantment> encantospicaretasilk = new ArrayList<>();
		List<Enchantment> encantosmachado = new ArrayList<>();
		List<Enchantment> encantospa = new ArrayList<>();
		encantospicaretasilk.add(Enchantment.DIG_SPEED);
		encantospicaretasilk.add(Enchantment.DURABILITY);
		encantospicaretasilk.add(Enchantment.SILK_TOUCH);
		encantosmachado.add(Enchantment.DIG_SPEED);
		encantosmachado.add(Enchantment.DURABILITY);
		encantosmachado.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantospicareta.add(Enchantment.DIG_SPEED);
		encantospicareta.add(Enchantment.DURABILITY);
		encantospicareta.add(Enchantment.LOOT_BONUS_BLOCKS);
		encantospa.add(Enchantment.SILK_TOUCH);
		encantospa.add(Enchantment.DURABILITY);
		encantospa.add(Enchantment.DIG_SPEED);
		encantosespada.add(Enchantment.DAMAGE_ALL);
		encantosespada.add(Enchantment.DURABILITY);
		encantosespada.add(Enchantment.LOOT_BONUS_MOBS);
		encantosarmadura.add(Enchantment.PROTECTION_ENVIRONMENTAL);
		encantosarmadura.add(Enchantment.DURABILITY);
		itemdivino.add(Criar.add(Material.GOLDEN_APPLE, 64, 1));
		itemdivino
				.add(Criar.add(Material.DIAMOND_HELMET, "§bCapacete de Diamante - Caixa Divina", encantosarmadura, 10));
		itemdivino.add(
				Criar.add(Material.DIAMOND_CHESTPLATE, "§bPeitoral de Diamante - Caixa Divina", encantosarmadura, 10));
		itemdivino
				.add(Criar.add(Material.DIAMOND_LEGGINGS, "§bCalça de Diamante - Caixa Divina", encantosarmadura, 10));
		itemdivino.add(Criar.add(Material.DIAMOND_BOOTS, "§bBotas de Diamante - Caixa Divina", encantosarmadura, 10));
		itemdivino.add(Criar.add(Material.DIAMOND_SWORD, "§bEspada De Diamante - Caixa Divina", encantosespada, 10));
		itemdivino.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Divina", encantospicareta, 10));
		itemdivino.add(Criar.add(Material.DIAMOND_AXE, "§bMachado De Diamante - Caixa Divina", encantosmachado, 10));
		itemdivino.add(Criar.add(Material.DIAMOND_SPADE, "§bPá De Diamante - Caixa Divina", encantospa, 10));
		itemdivino.add(
				Criar.add(Material.DIAMOND_PICKAXE, "§bPicareta De Diamante - Caixa Divina", encantospicaretasilk, 10));
	}
	
	
	public static void abrirCaixaBasica(Player p) {
		new BukkitRunnable() {
			int rotacao = 0;

			@Override
			public void run() {
				rotacao++;
				if (rotacao <= 20) {
					Inventory inv = Bukkit.createInventory(null, 9,
							"§bCaixa §eBasica");
					for (int i = 0; i < inv.getSize(); i++) {
						ItemStack itens = itembasico.get(new Random().nextInt(itembasico.size()));
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				}
				if (rotacao == 21) {
					Inventory inv = Bukkit.createInventory(null, 9, "§bCaixa §eBasica");
					ItemStack itens = itembasico.get(new Random().nextInt(itembasico.size()));
					for (int i = 0; i < inv.getSize(); i++) {
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.getInventory().addItem(itens);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.closeInventory();
				}
			}
		}.runTaskTimer(Main.getPlugin(), 0L, 5L);
	}

	public static void abrirCaixaMistica(Player p) {
		new BukkitRunnable() {
			int rotacao = 0;

			@Override
			public void run() {
				rotacao++;
				if (rotacao <= 20) {
					Inventory inv = Bukkit.createInventory(null, 9,
							"§bCaixa §eMistica");
					for (int i = 0; i < inv.getSize(); i++) {
						ItemStack itens = itemmistico.get(new Random().nextInt(itemmistico.size()));
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				}
				if (rotacao == 21) {
					Inventory inv = Bukkit.createInventory(null, 9, "§bCaixa §eMistica");
					ItemStack itens = itemmistico.get(new Random().nextInt(itemmistico.size()));
					for (int i = 0; i < inv.getSize(); i++) {
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.getInventory().addItem(itens);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.closeInventory();
				}
			}
		}.runTaskTimer(Main.getPlugin(), 0L, 5L);
	}

	public static void abrirCaixaEpica(Player p) {
		new BukkitRunnable() {
			int rotacao = 0;

			@Override
			public void run() {
				rotacao++;
				if (rotacao <= 20) {
					Inventory inv = Bukkit.createInventory(null, 9,
							"§bCaixa §eEpica");
					for (int i = 0; i < inv.getSize(); i++) {
						ItemStack itens = itemepico.get(new Random().nextInt(itemmistico.size()));
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				}
				if (rotacao == 21) {
					Inventory inv = Bukkit.createInventory(null, 9, "§bCaixa §eEpica");
					ItemStack itens = itemepico.get(new Random().nextInt(itemepico.size()));
					for (int i = 0; i < inv.getSize(); i++) {
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.getInventory().addItem(itens);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.closeInventory();
				}
			}
		}.runTaskTimer(Main.getPlugin(), 0L, 5L);
	}

	public static void abrirCaixaDivina(Player p) {
		new BukkitRunnable() {
			int rotacao = 0;

			@Override
			public void run() {
				rotacao++;
				if (rotacao <= 20) {
					Inventory inv = Bukkit.createInventory(null, 9,
							"§bCaixa §eDivina");
					for (int i = 0; i < inv.getSize(); i++) {
						ItemStack itens = itemdivino.get(new Random().nextInt(itemdivino.size()));
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.playSound(p.getLocation(), Sound.CLICK, 1F, 1F);
				}
				if (rotacao == 21) {
					Inventory inv = Bukkit.createInventory(null, 9, "§bCaixa §eDivina");
					ItemStack itens = itemdivino.get(new Random().nextInt(itemdivino.size()));
					for (int i = 0; i < inv.getSize(); i++) {
						inv.setItem(i, itens);
					}
					p.openInventory(inv);
					p.getInventory().addItem(itens);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					p.closeInventory();

				}
			}
		}.runTaskTimer(Main.getPlugin(), 0L, 5L);
	}
	
	
}
