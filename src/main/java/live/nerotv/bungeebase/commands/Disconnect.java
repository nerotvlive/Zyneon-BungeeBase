package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Disconnect extends Command {

    public Disconnect() {
        super("Disconnect",null,"disc","dc","quit");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)s;
            p.disconnect(API.getBaseComponent("§7Du hast den Server verlassen§8. §aDanke §7für's Spielen§8!"));
        } else {
            API.sendErrorMessage(API.needPlayer);
        }
    }
}
