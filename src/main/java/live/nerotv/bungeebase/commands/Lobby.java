package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import live.nerotv.bungeebase.api.NewSound;
import live.nerotv.bungeebase.api.PlayerAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {

    public Lobby() {
        super("Lobby",null,"hub","l");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)s;
            if(p.getServer().getInfo().getName().equalsIgnoreCase("Lobby-1")) {
                API.sendErrorMessage(p,"§cDu bist bereits auf der Lobby!");
            } else {
                p.connect(BungeeCord.getInstance().getServerInfo("Lobby-1"));
                PlayerAPI.playNewSound(p,NewSound.ENTITY_CHICKEN_EGG);
            }
        } else {
            API.sendErrorMessage(API.needPlayer);
        }
    }
}