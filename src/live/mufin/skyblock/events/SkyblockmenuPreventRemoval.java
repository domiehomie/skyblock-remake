package live.mufin.skyblock.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import live.mufin.skyblock.Main;



public class SkyblockmenuPreventRemoval implements Listener {
	

	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(event.getSlot() == 8) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if(event.getItemDrop().getItemStack().getItemMeta().getDisplayName().endsWith("(Right Click)")) {
			event.setCancelled(true);
		}
	}
}
