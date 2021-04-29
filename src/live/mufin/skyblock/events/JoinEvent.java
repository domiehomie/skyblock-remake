package live.mufin.skyblock.events;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import live.mufin.skyblock.Main;
import live.mufin.skyblock.playerdata.Stats.Stat;
import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener {

	private Main plugin;

	public JoinEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();
		UUID uuid = player.getUniqueId();
		World world = player.getWorld();

		plugin.getLogger().info("Player " + player.getName() + " joined. Creating playerdata.");
		// Creating player in playerdata.yml

		// GENERAL DATA
		plugin.data.getConfig().set(uuid.toString() + ".name", player.getName());
		plugin.data.getConfig().set(uuid.toString() + ".displayname", player.getDisplayName());
		plugin.data.getConfig().set(uuid.toString() + ".adress", player.getAddress().toString());
		plugin.data.getConfig().set(uuid.toString() + ".level", player.getLevel());
		plugin.data.getConfig().set(uuid.toString() + ".death", false);

		// LOCATION DATA
		plugin.data.getConfig().set(uuid.toString() + ".location.world", world.getName());
		plugin.data.getConfig().set(uuid.toString() + ".location.x", player.getLocation().getX());
		plugin.data.getConfig().set(uuid.toString() + ".location.y", player.getLocation().getY());
		plugin.data.getConfig().set(uuid.toString() + ".location.z", player.getLocation().getZ());
		plugin.data.getConfig().set(uuid.toString() + ".location.pitch", player.getLocation().getPitch());
		plugin.data.getConfig().set(uuid.toString() + ".location.yaw", player.getLocation().getYaw());

		// SKYBLOCK DATA
		if (!plugin.data.getConfig().contains(uuid.toString() + ".skyblock")) {
			plugin.data.getConfig().set(uuid.toString() + ".skyblock.coins", 0L);
			plugin.data.getConfig().set(uuid.toString() + ".skyblock.bits", 0);
			plugin.data.getConfig().set(uuid.toString() + ".skyblock.flightduration", 0L);
		}

		for (Stat stat : Stat.values()) {
			if (!plugin.data.getConfig().contains(player.getUniqueId() + ".skyblock.stat." + stat))
				plugin.data.getConfig().set(player.getUniqueId() + ".skyblock.stat." + stat, 0.0D);
		}

		// LOGGING DATA
		plugin.data.getConfig().set(uuid.toString() + ".logging.itemdrops", false);
		plugin.data.getConfig().set(uuid.toString() + ".logging.itemclicks", false);

		// GIVING SKYBLOCK MENU
		ItemStack skyblockmenu = plugin.item.getItem("SKYBLOCK_MENU");
		if (!(player.getInventory().contains(skyblockmenu))) {
			player.getInventory().setItem(8, skyblockmenu);
		}

		plugin.data.saveConfig();
	}

}
