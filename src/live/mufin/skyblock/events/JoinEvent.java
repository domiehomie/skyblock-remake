package live.mufin.skyblock.events;

import java.util.UUID;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import live.mufin.skyblock.Main;
import live.mufin.skyblock.playerdata.Stats.Stat;

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
		plugin.data.getConfig().set(uuid.toString() + ".name", player.getName());
		plugin.data.getConfig().set(uuid.toString() + ".displayname", player.getDisplayName());
		plugin.data.getConfig().set(uuid.toString() + ".adress", player.getAddress().toString());
		plugin.data.getConfig().set(uuid.toString() + ".level", player.getLevel());
		
		plugin.data.getConfig().set(uuid.toString() + ".location.world", world.getName());
		plugin.data.getConfig().set(uuid.toString() + ".location.x", player.getLocation().getX());
		plugin.data.getConfig().set(uuid.toString() + ".location.y", player.getLocation().getY());
		plugin.data.getConfig().set(uuid.toString() + ".location.z", player.getLocation().getZ());
		plugin.data.getConfig().set(uuid.toString() + ".location.pitch", player.getLocation().getPitch());
		plugin.data.getConfig().set(uuid.toString() + ".location.yaw", player.getLocation().getYaw());
		
		if(!plugin.data.getConfig().contains(uuid.toString() + ".skyblock")) {
			plugin.data.getConfig().set(uuid.toString() + ".skyblock.coins", 0L);
			plugin.data.getConfig().set(uuid.toString() + ".skyblock.bits", 0);
		}
		
		for (Stat stat : Stat.values()) {
			if(!plugin.data.getConfig().contains(player.getUniqueId() + ".skyblock.stat." + stat))
				plugin.data.getConfig().set(player.getUniqueId() + ".skyblock.stat." + stat, 0.0D);
		}
		
		
		plugin.data.saveConfig();
	}
	
	

}
