package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import live.nerotv.bungeebase.api.NewSound;
import live.nerotv.bungeebase.api.PlayerAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Teamchat extends Command {

    public Teamchat() {
        super("Teamchat",null,"tc");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s.hasPermission("zyneon.team")) {
            if (args.length == 0) {
                API.sendErrorMessage(s, "§4Fehler: §c/teamchat [Nachricht]");
            } else {
                String n;
                if(s instanceof ProxiedPlayer) {
                    ProxiedPlayer p = (ProxiedPlayer)s;
                    n = p.getName();
                } else {
                    n = "Konsole";
                }
                String m = "";
                for (int i = 0; i < args.length; i++) {
                    m = m + args[i] + " ";
                }
                String format = "§dTeamchat §8● §f"+n+"§8 » §7" + m.replace("&", "§");
                for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
                    if (all.hasPermission("zyneon.team")) {
                        API.sendMessage(all, format, false);
                        PlayerAPI.playNewSound(all,NewSound.ENTITY_CHICKEN_STEP);
                    }
                }
                API.sendMessage(format, false);
            }
        } else {
            API.sendErrorMessage(s,API.noPerms);
        }
    }
}