package live.mufin.skyblock.items.abilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import live.mufin.skyblock.Main;

public class MushroomSoup implements Listener {

	private Main plugin;
	public MushroomSoup(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEatSoup(PlayerInteractEvent event) {
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = event.getPlayer();
			ItemStack i = event.getItem();
			if (i == null) return;
			if(i.getItemMeta().getDisplayName().endsWith("Magical Mushroom Soup")) {
				i.setAmount(i.getAmount() - 1);
				p.getInventory().setItem(p.getInventory().getHeldItemSlot(), i);
				plugin.data.getConfig().set(p.getUniqueId().toString() + ".flightduration", plugin.data.getConfig().getLong(p.getUniqueId().toString() + ".flightduration") + 120);
				plugin.data.saveConfig();
			}
		}
	}
	
}
