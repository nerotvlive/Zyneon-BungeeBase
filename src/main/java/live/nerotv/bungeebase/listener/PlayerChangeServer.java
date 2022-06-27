package live.nerotv.bungeebase.listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerChangeServer implements Listener {

    @EventHandler
    public void onServerChange(ServerSwitchEvent e) {
        ProxiedPlayer p = e.getPlayer();
        String serverName = e.getPlayer().getServer().getInfo().getName();
        if(!serverName.toLowerCase().contains("lobby")) {
            p.sendMessage("§8»§7 Du bist nun auf §e" + serverName + "§8!");
        }
    }
}