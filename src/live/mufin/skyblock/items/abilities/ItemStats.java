package live.mufin.skyblock.items.abilities;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import live.mufin.skyblock.Main;
import live.mufin.skyblock.playerdata.Stats.Stat;

public class ItemStats{

	private Main plugin;
	
	public ItemStats(Main plugin) {
		this.plugin = plugin;
	}
	
	public void runnable() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for(Player p : Bukkit.getServer().getOnlinePlayers()) { 
					
					if(p.getInventory().getItemInMainHand() == null || p.getInventory().getItemInMainHand().getItemMeta() == null) {
						for (Stat stat : Stat.values()) {
							plugin.data.getConfig().set(p.getUniqueId()+ ".skyblock.itemstat." + stat, 0.0d);
						}
						plugin.data.saveConfig();
						return;
					}
					
					ItemStack currentItem = p.getInventory().getItemInMainHand();
					for(Stat stat : Stat.values()) {
						NamespacedKey key = new NamespacedKey(plugin, stat.toString());
						if(currentItem.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.DOUBLE)) {
							plugin.data.getConfig().set(p.getUniqueId() + ".skyblock.itemstat." + stat, currentItem.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE));
						}
						
					}
					plugin.data.saveConfig();
					
						
					
					
				}
			}
			
		}.runTaskTimer(plugin, 0, 1);
	}
	
	
}