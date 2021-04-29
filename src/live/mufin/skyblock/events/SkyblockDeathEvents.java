package live.mufin.skyblock.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import live.mufin.skyblock.Main;
import live.mufin.skyblock.PlayerDeath.DeathCause;

public class SkyblockDeathEvents implements Listener{
	
	private Main plugin;
	
	public SkyblockDeathEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	// VOID
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		Location l = p.getLocation();
		if(l.getY() <= 1) {
			plugin.death.setDeath(p, DeathCause.VOID);
		}
	}
	
	

	
	
	
}
