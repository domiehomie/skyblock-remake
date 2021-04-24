package live.mufin.skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;
import live.mufin.skyblock.playerdata.Stats.Stat;

public class StatsCommand implements CommandExecutor {

	private Main plugin;

	public StatsCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("stats")) {
			if (!(sender instanceof Player))
				return true;

			Player player = (Player) sender;

			if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				plugin.utils.sendFormattedMessage(player, "&7Stats for &a" + target.getDisplayName() + "&7:");

				plugin.utils.sendFormattedMessage(player, "&c❤ Health &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.HEALTH));
				plugin.utils.sendFormattedMessage(player, "&a❈  Defense &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.DEFENSE));
				plugin.utils.sendFormattedMessage(player, "&f❂ True Defense " + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.TRUE_DEFENSE));

				plugin.utils.sendFormattedMessage(player, "&c❁ Damage &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.DAMAGE));

				plugin.utils.sendFormattedMessage(player, "&c❁ Strength &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.STRENGTH));

				plugin.utils.sendFormattedMessage(player, "&f✦ Speed " + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.SPEED));

				plugin.utils.sendFormattedMessage(player, "&9☣ Crit Chance &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.CRIT_CHANCE));

				plugin.utils.sendFormattedMessage(player, "&9☠ Crit Damage &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.CRIT_DMG));

				plugin.utils.sendFormattedMessage(player, "&b✎ Intelligence &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.INTELLIGENCE));

				plugin.utils.sendFormattedMessage(player, "&6⸕ Mining Speed &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MINING_SPEED));

				plugin.utils.sendFormattedMessage(player, "&3α Sea Creature Chance &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.SEACREATURESPAWNRATE));

				plugin.utils.sendFormattedMessage(player, "&b✯ Magic Find &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MAGICFIND));

				plugin.utils.sendFormattedMessage(player, "&d♣ Pet Luck &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.PETLUCK));

				plugin.utils.sendFormattedMessage(player, "&c✹ Ability Damage &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.ABILITYDAMAGE));

				plugin.utils.sendFormattedMessage(player, "&c⫽ Ferocity &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FEROCITY));

				plugin.utils.sendFormattedMessage(player, "&6☘ Mining Fortune &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MINING_FORTUNE));

				plugin.utils.sendFormattedMessage(player, "&6☘ Farming Fortune &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FARMING_FORTUNE));

				plugin.utils.sendFormattedMessage(player, "&6☘ Foraging Fortune &f" + plugin.data.getConfig()
						.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FORAGING_FORTUNE));

				return true;
			}

			plugin.utils.sendFormattedMessage(player, "&7Stats for &a" + player.getDisplayName() + "&7:");

			plugin.utils.sendFormattedMessage(player, "&c❤ Health &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.HEALTH));

			plugin.utils.sendFormattedMessage(player, "&a❈  Defense &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.DEFENSE));

			plugin.utils.sendFormattedMessage(player, "&f❂ True Defense " + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.TRUE_DEFENSE));

			plugin.utils.sendFormattedMessage(player, "&c❁ Damage &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.DAMAGE));

			plugin.utils.sendFormattedMessage(player, "&c❁ Strength &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.STRENGTH));

			plugin.utils.sendFormattedMessage(player, "&f✦ Speed " + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.SPEED));

			plugin.utils.sendFormattedMessage(player, "&9☣ Crit Chance &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.CRIT_CHANCE));

			plugin.utils.sendFormattedMessage(player, "&9☠ Crit Damage &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.CRIT_DMG));

			plugin.utils.sendFormattedMessage(player, "&b✎ Intelligence &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.INTELLIGENCE));

			plugin.utils.sendFormattedMessage(player, "&6⸕ Mining Speed &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.MINING_SPEED));

			plugin.utils.sendFormattedMessage(player, "&3α Sea Creature Chance &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.SEACREATURESPAWNRATE));

			plugin.utils.sendFormattedMessage(player, "&b✯ Magic Find &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.MAGICFIND));

			plugin.utils.sendFormattedMessage(player, "&d♣ Pet Luck &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.PETLUCK));

			plugin.utils.sendFormattedMessage(player, "&c✹ Ability Damage &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.ABILITYDAMAGE));

			plugin.utils.sendFormattedMessage(player, "&c⫽ Ferocity &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.FEROCITY));

			plugin.utils.sendFormattedMessage(player, "&6☘ Mining Fortune &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.MINING_FORTUNE));

			plugin.utils.sendFormattedMessage(player, "&6☘ Farming Fortune &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.FARMING_FORTUNE));

			plugin.utils.sendFormattedMessage(player, "&6☘ Foraging Fortune &f" + plugin.data.getConfig()
					.getDouble(player.getUniqueId() + ".skyblock.stat." + Stat.FORAGING_FORTUNE));

			return true;
		}

		return true;
	}

}
