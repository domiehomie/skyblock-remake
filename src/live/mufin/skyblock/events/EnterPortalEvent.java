package live.mufin.skyblock.events;


import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EnterPortalEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEnterPortal(PlayerPortalEvent event) {

        if(event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.performCommand("goto world");
        }
        else if(event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.performCommand("goto hub");
        }
    }

    @EventHandler
    public void onTouchPortal(EntityPortalEvent event) {
        if(event.getEntity().getType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            player.performCommand("goto hub");
        }
    }
}
