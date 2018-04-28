package io.github.pepsifire.adminmenu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventListener implements Listener {

	//Constructor
	public EventListener(Main plugin) {
		
		
	}
	
	//EventHandler
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		if(player.hasPermission("adminmenu.use")) {
			player.sendMessage("You have access to the admin menu using /adminmenu");
		}
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		Inventory inv = event.getInventory();
		
		if (inv.getName().toLowerCase().contains("menu") && event.getSlotType() != SlotType.OUTSIDE) {
			
			ItemStack item = event.getCurrentItem();
			
			if (item.hasItemMeta() && item.getItemMeta().getDisplayName().contains("Stick of Knockback")) {
				ItemStack stick = new ItemStack(new ItemBuilder().buildStick(1));
				player.getInventory().addItem(stick);
				event.setCancelled(true);
			}
			
			if (item.hasItemMeta() && item.getItemMeta().getDisplayName().contains("Toggle Invisibility")) {
				
				if (!player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true, false));
				} else {
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
				}
				event.setCancelled(true);
			}
			if (item.hasItemMeta() && item.getItemMeta().getDisplayName().contains("Access Admin Menu")) {
				ItemStack com = new ItemStack(new ItemBuilder().adminCompass(1));
				player.getInventory().addItem(com);
				event.setCancelled(true);
			}
			
			
			// No clicking on the glass panes
			if (item.getType().equals(Material.STAINED_GLASS_PANE)) {
				event.setCancelled(true);
			}
		
		}
	}
	@EventHandler
	public void compassMenu(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		
			ItemStack item = player.getInventory().getItemInMainHand();
			if (item.hasItemMeta() && item.getItemMeta().getDisplayName() != null) {
				if (item.getItemMeta().getDisplayName().contains("Access Admin Menu")) {
				Inventory inv = new MenuStorage().adminInv();
				player.openInventory(inv);
			}
	}
}
}