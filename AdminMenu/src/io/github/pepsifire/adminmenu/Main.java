package io.github.pepsifire.adminmenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("Pepsifire's AdminMenu loaded");
		PluginManager pm = getServer().getPluginManager();
		EventListener listener = new EventListener(this);
		pm.registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Pepsifire's AdminMenu unloaded!");
	}
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player) {
			String lowerCmd = cmd.getName().toLowerCase();
			
			switch (lowerCmd) {
			
			case "adminmenu":
				Inventory inv = new MenuStorage().adminInv();
				player.openInventory(inv);
				return true;
			
			default:
				player.sendMessage("Your command was not recognized.");
				return true;
			
			}
			
		}
		
		
		
		return true;
	}
}