package live.mufin.skyblock;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Utils {
	
	private Main plugin;
	
	public Utils(Main plugin) {
		this.plugin = plugin;
	}
	
	public void sendFormattedMessage(Player player, String message) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aSB&8]&r " + message));
		return;
	}
	
	
}
