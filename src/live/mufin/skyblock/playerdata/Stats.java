package live.mufin.skyblock.playerdata;

import org.bukkit.entity.Player;

import live.mufin.skyblock.Main;

public class Stats {

	private Main plugin;

	public Stats(Main plugin) {
		this.plugin = plugin;
	}

	public enum Stat {
		DAMAGE, HEALTH, DEFENSE, TRUE_DEFENSE, STRENGTH, SPEED, CRIT_CHANCE, CRIT_DMG, INTELLIGENCE, MINING_SPEED,
		SEACREATURESPAWNRATE, MAGICFIND, PETLUCK, ABILITYDAMAGE, FEROCITY, MINING_FORTUNE, FARMING_FORTUNE,
		FORAGING_FORTUNE
	}

	public String getStatString(Stat stat, Player target) {
		switch (stat) {
		case HEALTH:
			return "&c❤ Health &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.HEALTH);

		case ABILITYDAMAGE:
			return "&c✹ Ability Damage &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.ABILITYDAMAGE);

		case CRIT_CHANCE:
			return "&9☣ Crit Chance &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.CRIT_CHANCE);

		case CRIT_DMG:
			return "&9☠ Crit Damage &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.CRIT_DMG);

		case DAMAGE:
			return "&c❁ Damage &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.DAMAGE);

		case DEFENSE:
			return "&a❈  Defense &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.DEFENSE);

		case FARMING_FORTUNE:
			return "&6☘ Farming Fortune &f" + plugin.data.getConfig()
					.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FARMING_FORTUNE);

		case FEROCITY:
			return "&c⫽ Ferocity &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FEROCITY);

		case FORAGING_FORTUNE:
			return "&6☘ Foraging Fortune &f" + plugin.data.getConfig()
					.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.FORAGING_FORTUNE);

		case INTELLIGENCE:
			return "&b✎ Intelligence &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.INTELLIGENCE);

		case MAGICFIND:
			return "&b✯ Magic Find &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MAGICFIND);

		case MINING_FORTUNE:
			return "&6☘ Mining Fortune &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MINING_FORTUNE);

		case MINING_SPEED:
			return "&6⸕ Mining Speed &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.MINING_SPEED);

		case PETLUCK:
			return "&d♣ Pet Luck &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.PETLUCK);

		case SEACREATURESPAWNRATE:
			return "&3α Sea Creature Chance &f" + plugin.data.getConfig()
					.getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.SEACREATURESPAWNRATE);

		case SPEED:
			return "&f✦ Speed "
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.SPEED);

		case STRENGTH:
			return "&c❁ Strength &f"
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.STRENGTH);

		case TRUE_DEFENSE:
			return "&f❂ True Defense "
					+ plugin.data.getConfig().getDouble(target.getUniqueId() + ".skyblock.stat." + Stat.TRUE_DEFENSE);

		}
		return null;
	}
	
	public double getStatValue(Stat stat, Player target) {
		return plugin.data.getConfig().getDouble(target.getUniqueId().toString() + ".skyblock.stat." + stat);
	}
	

}
