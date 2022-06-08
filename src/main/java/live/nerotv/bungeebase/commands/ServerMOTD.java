package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ServerMOTD extends Command {

    public ServerMOTD() {
        super("ServerMOTD",null,"motd");
    }

    private void sendSyntax(CommandSender s) {
        API.sendErrorMessage(s,"§4Fehler: §c/motd [1/2] [Inhalt]");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s.hasPermission("zyneon.leading.servermotd")) {
            if(args.length == 0) {
                sendSyntax(s);
            } else if(args.length == 1) {
                sendSyntax(s);
            } else {
                String r = "";
                for (int i = 1; i < args.length; i++) {
                    r = r + args[i] + " ";
                }
                r = r.substring(0, r.length() - 1);
                r = r.replace("&","§");
                if(args[0].equalsIgnoreCase("1")) {
                    API.setMotd(1,r);
                    API.sendMessage(s,"Du hast die erste §eZeile der MOTD §7auf §a"+r+"§7 gesetzt§8!");
                } else if(args[0].equalsIgnoreCase("2")) {
                    API.setMotd(2,r);
                    API.sendMessage(s,"Du hast die zweite §eZeile der MOTD §7auf §a"+r+"§7 gesetzt§8!");
                } else {
                    sendSyntax(s);
                }
            }
        } else {
            API.sendErrorMessage(s,API.noPerms);
        }
    }
}
