package live.mufin.skyblock.commands.tabcompleters;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;

public class SetLoggerTabComplete implements TabCompleter {

	private Main plugin;

	public SetLoggerTabComplete(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		List<String> features = new ArrayList<String>();
		if (features.isEmpty()) {
			for (String feature : plugin.data.getConfig().getKeys(true)) {
				if (feature.startsWith(player.getUniqueId().toString() + ".logging.")) {
					String defaultLogging = player.getUniqueId().toString() + ".logging.";
					features.add(feature.replace(defaultLogging, ""));
				}
			}
		}

		List<String> results = new ArrayList<String>();
		if (args.length == 1) {
			for (String result : features) {
				if (result.toLowerCase().startsWith(args[0].toLowerCase()))
					results.add(result);
			}
			return results;

		}

		List<String> booleanvalues = new ArrayList<String>();
		booleanvalues.add("true");
		booleanvalues.add("false");

		if (args.length == 2) {
			results.clear();
			for (String result : booleanvalues) {
				if (result.toLowerCase().startsWith(args[1].toLowerCase()))
					results.add(result);
			}
			return results;
		}

		return null;
	}

}
