package live.mufin.skyblock;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class Utils {
	
	private Main plugin;
	
	public Utils(Main plugin) {
		this.plugin = plugin;
	}
	
	
	// Sending Messages
	public void sendFormattedMessage(Player player, String message) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aSB&8]&r " + message));
		return;
	}
	
	
	// Sending logger message (needed for command)
	public void sendLoggerMessage(Player player) {
		List<String> features = new ArrayList<String>();
		for (String feature : plugin.data.getConfig().getKeys(true)) {
			if (feature.startsWith(player.getUniqueId().toString() + ".logging.")) {
				String defaultLogging = player.getUniqueId().toString() + ".logging.";
				features.add(feature.replace(defaultLogging, ""));
			}
		}

		plugin.utils.sendFormattedMessage(player, "&7Showing logger options: ");
		plugin.utils.sendFormattedMessage(player, "&8================================");

		
		for (String feature : features) {
			if (plugin.data.getConfig().getBoolean(player.getUniqueId().toString() + ".logging." + feature)) {
				TextComponent msg = new TextComponent(TextComponent.fromLegacyText(
						ChatColor.translateAlternateColorCodes('&', "&8[&aEnabled&8] &7- &a" + feature)));
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + "setlogger " + feature + " false"));
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
						new Text(ChatColor.translateAlternateColorCodes('&', "&7Click to &cdisable &7this feature!"))));
				player.spigot().sendMessage(msg);
			} else {
				TextComponent msg = new TextComponent(TextComponent.fromLegacyText(
						ChatColor.translateAlternateColorCodes('&', "&8[&cDisabled&8] &7- &a" + feature)));
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + "setlogger " + feature + " true"));
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
						new Text(ChatColor.translateAlternateColorCodes('&', "&7Click to &aenable &7this feature!"))));
				player.spigot().sendMessage(msg);
			}
		}
	}
	
	
}
