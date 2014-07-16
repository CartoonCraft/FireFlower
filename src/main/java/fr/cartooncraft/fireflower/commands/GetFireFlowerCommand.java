package fr.cartooncraft.fireflower.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.cartooncraft.fireflower.CCCommand;

public class GetFireFlowerCommand extends CCCommand {

	public GetFireFlowerCommand(CommandSender sender, String[] args) {
		if(sender.isOp()) {
			if(args.length == 0) {
				if(isPlayer(sender)) {
					ItemStack FireFlower = new ItemStack(Material.RED_ROSE);
					FireFlower.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
					ItemMeta meta = FireFlower.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD+"FIRE FLOWER!");
					meta.setLore(Arrays.asList("Put the world on fire!!!"));
					FireFlower.setItemMeta(meta);
					getPlayer(sender).getInventory().addItem(FireFlower);
					sender.sendMessage(ChatColor.GOLD+"I just gave you a fire flower!");
				}
				else {
					sender.sendMessage(senderConsole);
				}
			}
			else if(args.length == 1) {
				if(isPlayer(args[0])) {
					ItemStack FireFlower = new ItemStack(Material.RED_ROSE);
					FireFlower.addEnchantment(Enchantment.ARROW_FIRE, 1);
					ItemMeta meta = FireFlower.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD+"FIRE FLOWER!");
					meta.setLore(Arrays.asList("Put the world on fire!!!"));
					getPlayer(args[0]).getInventory().addItem(FireFlower);
				}
				else {
					sender.sendMessage(getPlayerNotFoundSentence(args[0]));
				}
			}
			else {
				sender.sendMessage(ChatColor.RED+"Nope! Usage: /getfireflower [player]");
			}
		}
		else {
			sender.sendMessage(noPermission);
		}
	}
}
