package live.mufin.skyblock.playerdata;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

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
					+ this.getStatValue(stat, target);
		case ABILITYDAMAGE:
			return "&c✹ Ability Damage &f"
					+ this.getStatValue(stat, target);

		case CRIT_CHANCE:
			return "&9☣ Crit Chance &f"
					+ this.getStatValue(stat, target);

		case CRIT_DMG:
			return "&9☠ Crit Damage &f"
					+ this.getStatValue(stat, target);

		case DAMAGE:
			return "&c❁ Damage &f"
					+ this.getStatValue(stat, target);

		case DEFENSE:
			return "&a❈  Defense &f"
					+ this.getStatValue(stat, target);

		case FARMING_FORTUNE:
			return "&6☘ Farming Fortune &f" + this.getStatValue(stat, target);

		case FEROCITY:
			return "&c⫽ Ferocity &f"
					+ this.getStatValue(stat, target);

		case FORAGING_FORTUNE:
			return "&6☘ Foraging Fortune &f" + this.getStatValue(stat, target);

		case INTELLIGENCE:
			return "&b✎ Intelligence &f"
					+ this.getStatValue(stat, target);

		case MAGICFIND:
			return "&b✯ Magic Find &f"
					+ this.getStatValue(stat, target);

		case MINING_FORTUNE:
			return "&6☘ Mining Fortune &f"
					+ this.getStatValue(stat, target);

		case MINING_SPEED:
			return "&6⸕ Mining Speed &f"
					+ this.getStatValue(stat, target);

		case PETLUCK:
			return "&d♣ Pet Luck &f"
					+ this.getStatValue(stat, target);

		case SEACREATURESPAWNRATE:
			return "&3α Sea Creature Chance &f" + this.getStatValue(stat, target);

		case SPEED:
			return "&f✦ Speed "
					+ this.getStatValue(stat, target);

		case STRENGTH:
			return "&c❁ Strength &f"
					+ this.getStatValue(stat, target);

		case TRUE_DEFENSE:
			return "&f❂ True Defense "
					+ this.getStatValue(stat, target);

		}
		return null;
	}
	
	
	public double getStatValue(Stat stat, Player target) {
		NamespacedKey key = new NamespacedKey(plugin, stat.toString());
		NamespacedKey itemKey = new NamespacedKey(plugin, "item_" + stat.toString());
		if(target.getPersistentDataContainer().has(itemKey, PersistentDataType.DOUBLE)) {
			return target.getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) + target.getPersistentDataContainer().get(itemKey, PersistentDataType.DOUBLE);
		}else {
			return target.getPersistentDataContainer().get(key, PersistentDataType.DOUBLE);
		}
		
	}
	

}
