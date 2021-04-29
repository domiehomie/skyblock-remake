package live.mufin.skyblock.items.abilities;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import live.mufin.skyblock.Main;

public class MushroomSoup implements Listener{

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
				p.setAllowFlight(true);
				p.setFlying(true);
				plugin.utils.sendFormattedMessage(p, "&aYou drank a mysterious soup and gained &c2&a minutes of flight.");
				plugin.data.getConfig().set(p.getUniqueId().toString() + ".skyblock.flightduration", plugin.data.getConfig().getLong(p.getUniqueId().toString() + ".skyblock.flightduration") + 120);
				plugin.data.saveConfig();
				plugin.board.createBoard(p);
			}
		}
	}

	public void runnable() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for(String player : plugin.data.getConfig().getKeys(false)) {
					try {
						UUID uuid = UUID.fromString(player);
						Player p = Bukkit.getPlayer(uuid);
						int time = plugin.data.getConfig().getInt(uuid.toString() + ".skyblock.flightduration");
						if(time != 0) {
							if(plugin.data.getConfig().getString(uuid.toString() + ".location.world").equals("world")) {
								plugin.data.getConfig().set(uuid.toString() + ".skyblock.flightduration", time - 1);
								plugin.data.saveConfig();
								plugin.board.createBoard(p);
								switch(time) {
								case 60:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 60 seconds!");
									break;
								case 30:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 30 seconds!");
									break;
								case 10:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 10 seconds!");
									break;
								case 5:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 5 seconds!");
									break;
								case 4:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 4 seconds!");
									break;
								case 3:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 3 seconds!");
									break;
								case 2:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 2 seconds!");
									break;
								case 1:
									plugin.utils.sendFormattedMessage(p, "&cYour flight will run out in 1 second!");
									p.setFlying(false);
									p.setAllowFlight(false);
									break;
									
								}
								
							}
							
						}
					} catch (NullPointerException e) {

					}
				}
			}
			
		}.runTaskTimer(plugin, 0, 20);
	}
}
