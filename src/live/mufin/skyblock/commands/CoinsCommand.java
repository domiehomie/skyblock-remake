package live.mufin.skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;

public class CoinsCommand implements CommandExecutor {

	private Main plugin;

	public CoinsCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("coins") || label.equalsIgnoreCase("balance")) {
			if(!(sender instanceof Player))
				return true;
			
			Player player = (Player) sender;
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				plugin.utils.sendFormattedMessage(player, "&7Coins for &a" + player.getDisplayName() + "&7: &6" + plugin.data.getConfig().getLong(target.getUniqueId().toString() + ".skyblock.coins"));
			}else {
			plugin.utils.sendFormattedMessage(player, "&7Coins for &a" + player.getDisplayName() + "&7: &6" + plugin.data.getConfig().getLong(player.getUniqueId().toString() + ".skyblock.coins"));
			}
		}

		return true;
	}
	
}
