package live.nerotv.bungeebase.listener;

import de.dytanic.cloudnet.ext.bridge.node.CloudNetBridgeModule;
import live.nerotv.bungeebase.api.API;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class Join implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if(API.isPlayerBanned(p)||API.isPlayerBanned(p.getName())||API.isPlayerBanned(p.getAddress().getHostString())) {
            API.sendBanMessage(p);
        }
        if(p.getPendingConnection().getVersion()<API.lowestProtocol) {
            p.disconnect(API.getBaseComponent("§cBitte §4aktualisiere§c dein Spiel!\n§cWir unterstützen die Versionen §4"+API.lowestVersion+"§c bis §4"+API.highestVersion+"§c!"));
        }
        if(API.maintenance) {
            if(p.getName().equalsIgnoreCase("nerotvlive")) {
                return;
            }
            if(!p.hasPermission("zyneon.bypassmaintenance")) {
                p.disconnect(API.getBaseComponent("§cDer Server ist zurzeit in §4Wartungsarbeiten§c!\n§cVersuche es später erneut!"));
            }
        }
    }
}