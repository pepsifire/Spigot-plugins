package io.github.pepsifire.adminmenu;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class ItemBuilder {

public ItemStack makeItem(Material m, String name, String desc, int amount, int dmg, Enchantment enchant, int enchantLevel) {
		
		ItemStack item = new ItemStack(m, amount, (short) dmg);
		
		//Create meta data
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		//Create lore
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		if (enchant != null && enchantLevel != 0) {
			im.addEnchant(enchant, enchantLevel, true);
		}
		
		//Hide vanilla tooltip
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		//Set item meta data
		item.setItemMeta(im);
		
		//return the item
		return item;
		
		
	}
	
	public ItemStack buildCompass(int amount) {
		
		Material m = Material.COMPASS;
		String name = (ChatColor.GOLD + "Open Menus");
		String desc = ("Right click to open a menu!");
		short dmg = 0;
		
		return makeItem(m, name, desc, amount, dmg, null, 1);
	}
	public ItemStack buildStick(int amount) {
		
		Material m = Material.STICK;
		String name = ChatColor.GOLD + "Stick of Knockback" + ChatColor.RESET;
		String desc = ("Bye lol");
		int dmg = 0;
		Enchantment enchant = Enchantment.KNOCKBACK;
		int enchantLevel = 20;
		
		return makeItem(m, name, desc, amount, dmg, enchant,enchantLevel);
		
	}
	public ItemStack potionBuilder(String name, PotionType type, int level, boolean extend, boolean upgraded) {
		ItemStack potion = new ItemStack(Material.POTION, 1);
		PotionMeta meta = (PotionMeta) potion.getItemMeta();
		meta.setBasePotionData(new PotionData(type, extend, upgraded));
		meta.setDisplayName(name);
		potion.setItemMeta(meta);
		return potion;
	}
	public ItemStack adminCompass(int amount) {
		ItemStack compass = new ItemStack(makeItem(Material.COMPASS, "Access Admin Menu", "Shiny", 1, 0, null, 0));
		compass.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
		return compass;
	}
}

