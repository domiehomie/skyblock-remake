package live.mufin.skyblock.commands.tabcompleters;

import live.mufin.skyblock.playerdata.SQLGetter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CollectionTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> collections = new ArrayList<String>();
        if(collections.isEmpty()) {
            for(SQLGetter.Collection collection : SQLGetter.Collection.values()) {
                collections.add(collection.toString());
            }
        }

        List<String> results = new ArrayList<String>();

        if(args.length == 2) {
            for(String result : collections) {
                if(result.toUpperCase().startsWith(args[1].toUpperCase()))
                    results.add(result);
            }
            return results;
        }


        return null;
    }
}
