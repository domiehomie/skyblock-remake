package live.mufin.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.md_5.bungee.api.ChatColor;

public class PlayerDeath implements Listener{

	private Main plugin;
	
	public PlayerDeath(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public enum DeathCause {
		FALL,
		SUFFOCATE,
		EXPLOSION,
		FIRE,
		VOID,
		OTHER
	}
	
	public void setDeath(Player p, DeathCause cause) {
		switch(cause) {
		case FALL:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " has fallen to their death.");
			break;
		case EXPLOSION:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " has exploded.");
			break;
		case FIRE:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " has burnt to death.");
			break;
		case OTHER:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " died.");
			break;
		case SUFFOCATE:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " suffocated to death.");
			break;
		case VOID:
			Bukkit.getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " fell into the void.");
			break;
		}
		p.teleport(p.getLocation().getWorld().getSpawnLocation());
		plugin.data.getConfig().set(p.getUniqueId().toString() + ".death", true);
		plugin.data.saveConfig();
	}
	
	@EventHandler
	public void onFall(EntityDamageEvent event) {
		if (!(event.getEntityType() == EntityType.PLAYER)) return;
		if(!(event.getCause() == DamageCause.FALL)) return;
		Player p = (Player) event.getEntity();
		if(!(plugin.data.getConfig().getBoolean(p.getUniqueId().toString() + ".death"))) return;
		event.setCancelled(true);
		plugin.data.getConfig().set(p.getUniqueId().toString() + ".death", false);
		plugin.data.saveConfig();
	}
	
	
}
