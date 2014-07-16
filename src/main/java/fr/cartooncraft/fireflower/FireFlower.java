package fr.cartooncraft.fireflower;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cartooncraft.fireflower.commands.GetFireFlowerCommand;
import fr.cartooncraft.fireflower.events.RightClickEvent;

public class FireFlower extends JavaPlugin {

	public void onEnable() {
		getLogger().info("FireFlower is enabled!");
		Bukkit.getPluginManager().registerEvents(new RightClickEvent(), this);
	}
	
	public void onDisable() {
		getLogger().info("FireFlower is disabled! :(");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("getFireFlower"))
			new GetFireFlowerCommand(sender, args);
		else
			return false;
		return true;
	}
	
}
