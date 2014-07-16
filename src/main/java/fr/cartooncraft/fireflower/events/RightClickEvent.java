package fr.cartooncraft.fireflower.events;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class RightClickEvent implements Listener {

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			
			ItemStack FireFlower = new ItemStack(Material.RED_ROSE);
			FireFlower.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
			ItemMeta meta = FireFlower.getItemMeta();
			meta.setDisplayName(ChatColor.GOLD+"FIRE FLOWER!");
			meta.setLore(Arrays.asList("Put the world on fire!!!"));
			FireFlower.setItemMeta(meta);
			
			/*if(e.getItem().getType() == Material.RED_ROSE && e.getItem().getItemMeta().getDisplayName() == ChatColor.GOLD+"FIRE FLOWER!" && e.getItem().getItemMeta().getLore() == Arrays.asList("Put the world on fire!!!") && e.getItem().getItemMeta().getEnchants() == meta.getEnchants()) {*/
			if(e.getItem().getType() == Material.RED_ROSE && e.getItem().getItemMeta().getDisplayName().contains("FIRE FLOWER!")) {
				Player p = e.getPlayer();
				Vector dir = p.getEyeLocation().getDirection().multiply(2);
				Fireball fb = p.getWorld().spawn(p.getEyeLocation().add(dir.getX(), dir.getY(), dir.getZ()), Fireball.class);
				fb.setShooter(p);
				fb.setDirection(dir);
				fb.setIsIncendiary(true);
				fb.setYield(0);
				fb.setBounce(false);
			}
		}
	}
	
}
