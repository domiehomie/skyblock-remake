package live.mufin.skyblock.entities;

import org.bukkit.NamespacedKey;

import live.mufin.skyblock.Main;

public class entityNamespacedKeys {
	public static NamespacedKey name;
	public static NamespacedKey max_health;
	public static NamespacedKey health;
	public static NamespacedKey damage;
	public static NamespacedKey strength;
	public static NamespacedKey defense;

	public static NamespacedKey attribute_invisable;
	public static NamespacedKey attribute_combust;
	public static NamespacedKey attribute_ttl;
	
	private Main plugin;

	public entityNamespacedKeys(Main plugin) {
		this.plugin = plugin;

		name = new NamespacedKey(this.plugin, "entity_name");

	}
}
