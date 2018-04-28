package io.github.pepsifire.adminmenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {

	public static ItemBuilder builder = new ItemBuilder();
	public GUI() {
		
	}
	
	public static Inventory buildGUI(String menuName, int slots, Material m, String name, String desc, int amount, int dmg) {
		Inventory inventory = Bukkit.createInventory(null, slots, menuName);
		ItemBuilder item = new ItemBuilder();
		ItemStack filler = item.makeItem(m, name, desc, amount, dmg, null, 0);
		for (int i=0; i<slots; i++) {
			inventory.setItem(i, new ItemStack(filler));
			
		}
		return inventory;
	}
	
}

