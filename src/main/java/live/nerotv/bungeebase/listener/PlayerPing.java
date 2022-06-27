package live.nerotv.bungeebase.listener;

import live.nerotv.bungeebase.Main;
import live.nerotv.bungeebase.api.API;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.event.TabCompleteResponseEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerPing implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPing(ProxyPingEvent e) {
        ServerPing ping = e.getResponse();
        ServerPing.Players players = ping.getPlayers();
        int Protocol = e.getConnection().getVersion();
        ServerPing.Protocol vers = ping.getVersion();
        if(Protocol == 4) {
            ping.setDescriptionComponent(API.getBaseComponent("Zyneon ist ein Minecraft Minispiel und Projektenetzwerk, aktiv seit 2016! Unser Hauptaugenmerk liegt auf den Projekten!"));
            ping.setVersion(new ServerPing.Protocol("§c" + API.lowestVersion + "-" + API.highestVersion, 1));
            vers.setName("§4ZyneonCord " + Main.getVersion());
        } else if(Protocol < API.lowestProtocol) {
            ping.setDescriptionComponent(API.getBaseComponent("§4zyneonstudios.com §8- §cBitte aktualisiere dein Spiel!\n§cWir unterstützen nur Versionen ab der " + API.lowestVersion + "!"));
            ping.setVersion(new ServerPing.Protocol("§c" + API.lowestVersion + "-" + API.highestVersion, 1));
            vers.setName("§4ZyneonCord " + Main.getVersion());
        } else if(Protocol > API.highestProtocol) {
            ping.setDescriptionComponent(API.getBaseComponent("§4zyneonstudios.com §8- §cDein Spiel ist zu aktuell! Wir\n§cunterstützen momentan Versionen bis zur " + API.highestVersion + "!"));
            ping.setVersion(new ServerPing.Protocol("§c" + API.lowestVersion + "-" + API.highestVersion, 1));
            vers.setName("§4ZyneonCord " + Main.getVersion());
        } else if(API.maintenance) {
            ping.setDescriptionComponent(API.getBaseComponent("§4zyneonstudios.com §8- §cWir sind in Wartungsarbeiten!\n§cVersuche es später erneut! §4[§c"+API.lowestVersion+"§4-§c"+API.highestVersion+"§4]"));
            ping.setVersion(new ServerPing.Protocol("§cWartungsarbeiten",1));
            vers.setName("§4ZyneonCord " + Main.getVersion());
        } else {
            vers.setName("§9ZyneonCord " + Main.getVersion());
            players.setSample(new ServerPing.PlayerInfo[]{
                    new ServerPing.PlayerInfo("§9ZyneonCord "+Main.getVersion(), "ZyneonCord "+Main.getVersion())
            });
            ping.setDescriptionComponent(API.getBaseComponent(API.getMotd(1).replace("%lV%",API.lowestVersion).replace("%hV%",API.highestVersion) + "\n" + API.getMotd(2).replace("%lV%",API.lowestVersion).replace("%hV%",API.highestVersion)));
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTab(TabCompleteEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTab(TabCompleteResponseEvent e) {
        e.setCancelled(true);
    }
}