package live.mufin.skyblock.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import live.mufin.skyblock.Main;

public class LoggingEvents implements Listener{
	
	private Main plugin;

	public LoggingEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(plugin.data.getConfig().getBoolean(player.getUniqueId().toString() + ".logging.itemclicks")) {
			try {
				plugin.utils.sendFormattedMessage(player, "&7New &bInventoryClickEvent&7:");
				plugin.utils.sendFormattedMessage(player, "&7Display name: &r" + event.getCurrentItem().getItemMeta().getDisplayName());
				plugin.utils.sendFormattedMessage(player, "&7Item: &a" + event.getCurrentItem().getType().toString());
				plugin.utils.sendFormattedMessage(player, "&7Left click: &a" + event.isLeftClick());
				plugin.utils.sendFormattedMessage(player, "&7Right click: &a" + event.isRightClick());
				plugin.utils.sendFormattedMessage(player, "&7Shift click: &a" + event.isShiftClick());
				plugin.utils.sendFormattedMessage(player, "&7Slot: " + event.getSlot());
			} catch (NullPointerException e ) {
				
			}
			
		}
		
	}
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(plugin.data.getConfig().getBoolean(player.getUniqueId().toString() +  ".logging.itemdrops")) {
			plugin.utils.sendFormattedMessage(player, "&7New &bPlayerDropItemEvent&7:");
			plugin.utils.sendFormattedMessage(player, "&7Name: &r" + event.getItemDrop().getItemStack().getItemMeta().getDisplayName());
			plugin.utils.sendFormattedMessage(player, "&7Item: &a" + event.getItemDrop().getItemStack().getType().toString());
			plugin.utils.sendFormattedMessage(player, "&7Amount: &a" + event.getItemDrop().getItemStack().getAmount());
			plugin.utils.sendFormattedMessage(player, "&7Lore:");
			plugin.utils.sendFormattedMessage(player, "&8========================");
			for(String loreitem : event.getItemDrop().getItemStack().getItemMeta().getLore()) { 
				plugin.utils.sendFormattedMessage(player, loreitem);
			}
		}
	}
}
