package live.mufin.skyblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;

public class SetLoggerCommand implements CommandExecutor {

	private Main plugin;

	public SetLoggerCommand(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("setlogger") || label.equalsIgnoreCase("sl")) {
			if (!(sender instanceof Player))
				return true;
			Player player = (Player) sender;

			Boolean value = Boolean.parseBoolean(args[1]);
			if (plugin.data.getConfig().contains(player.getUniqueId().toString() + ".logging." + args[0])) {
				plugin.data.getConfig().set(player.getUniqueId().toString() + ".logging." + args[0], value);
				plugin.data.saveConfig();
			} else {
				plugin.utils.sendFormattedMessage(player, "&cInvalid logging feature and/or value.");
			}
			plugin.utils.sendLoggerMessage(player);
		}

		return true;
	}

}
