package live.mufin.skyblock.commands.tabcompleters;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class SetLoggerTabComplete implements TabCompleter {

	

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		List<String> features = new ArrayList<String>();
		if (features.isEmpty()) {
			features.add("itemclicks");
			features.add("itemdrops");
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
