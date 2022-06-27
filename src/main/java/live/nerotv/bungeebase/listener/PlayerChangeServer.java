package live.nerotv.bungeebase.listener;

import live.nerotv.bungeebase.api.API;
import live.nerotv.bungeebase.utils.ZyneonPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerChangeServer implements Listener {

    @EventHandler
    public void onServerChange(ServerSwitchEvent e) {
        ProxiedPlayer p = e.getPlayer();
        ZyneonPlayer zP = API.zyneonPlayers.get(p.getUniqueId());
        zP.setInit(zP.getInit()+1);
        String serverName = e.getPlayer().getServer().getInfo().getName();
        if(zP.getInit()>=1) {
            p.sendMessage("§8»§7 Du bist nun auf §e" + serverName + "§8!");
        } else {
            p.sendMessage("§8» §a"+p.getName());
        }
    }
}