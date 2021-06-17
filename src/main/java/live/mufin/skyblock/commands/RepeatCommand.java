package live.mufin.skyblock.commands;

import live.mufin.skyblock.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RepeatCommand implements CommandExecutor {

  private String cmd;

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!label.equalsIgnoreCase("repeat")) return true;
    if(!(sender instanceof Player)) return true;
    int delay = Integer.parseInt(args[0]);
    cmd = "";
    for(int i = 0; i < args.length; i++) {
     if(i == 0) break;
     cmd = cmd + args[i] + " ";
    }
    new BukkitRunnable() {
      @Override
      public void run() {
        Bukkit.dispatchCommand(sender, cmd);
      }
    }.runTaskTimer(Main.plugin, 0, delay);
    return true;
  }
}
