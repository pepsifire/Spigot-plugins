package io.github.pepsifire.adminmenu;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

public class MenuStorage {

	public Inventory adminInv() {
		Inventory inv = GUI.buildGUI("Admin Menu", 9, Material.STAINED_GLASS_PANE, "Hello", "There", 1, 15);
		inv.setItem(1, new ItemStack(new ItemBuilder().buildStick(1)));
		ItemStack invispotion = new ItemBuilder().potionBuilder("Toggle Invisibility", PotionType.INVISIBILITY, 10, true, false);
		inv.setItem(3, new ItemStack(invispotion));
		inv.setItem(5, new ItemStack(new ItemBuilder().adminCompass(1)));
		
		return inv;
	}
}