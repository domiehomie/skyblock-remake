package live.mufin.skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;

public class SetFlightCommand implements CommandExecutor {

	private Main plugin;
	public SetFlightCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("setflight")) {
			if(!(sender instanceof Player)) return true;
				if(args.length != 2) return false;
				
				Player player = (Player) sender;
				try {
					Player target = Bukkit.getPlayer(args[0]);
					int duration = Integer.parseInt(args[1]);
					if(duration == 0) plugin.utils.sendFormattedMessage(player, "&cFlight duration cannot be set to 0.");
					plugin.data.getConfig().set(target.getUniqueId() + ".skyblock.flightduration", duration);
					plugin.data.saveConfig();
					plugin.utils.sendFormattedMessage(player, "&7Set flight duration of &a" + target.getName() + "&7 to &a" + duration + "&7.");
					target.setAllowFlight(true);
					target.setFlying(true);
				} catch (IllegalArgumentException | NullPointerException e) {
					plugin.utils.sendFormattedMessage(player, "&cInvalid player/value.");
				}
				
		}
		
		return true;
	}
	
}
