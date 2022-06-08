package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import live.nerotv.bungeebase.api.BanAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class IPBan extends Command {

    public IPBan() {
        super("IPBan",null,"banip");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        if(s.hasPermission("zyneon.leading.banip")||s.hasPermission("zyneon.leading.ipban")) {
            if(args.length == 0) {
                API.sendErrorMessage(s,"§4Fehler: §c/ipban [Spieler/IP] §7[Grund]");
            } else {
                String r;
                if(args.length == 1) {
                    r = "§cRegelverstoß ";
                } else {
                    r = "";
                    for(int i=1;i<args.length;i++) {
                        r=r+args[i]+" ";
                    }
                }
                String a;
                if(BungeeCord.getInstance().getPlayer(args[0])!=null) {
                    ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
                    a = t.getAddress().getHostString();
                    BanAPI.ban(t,r);
                    BanAPI.ban(a,r);
                } else {
                    a = args[0];
                    BanAPI.ban(a,r);
                }
                String name = "der Konsole";
                if(s instanceof ProxiedPlayer) {
                    ProxiedPlayer p = (ProxiedPlayer)s;
                    name = p.getName();
                }
                API.sendMessage(s,"§7Du hast die IP §e"+a+"§7 für §c"+r+"§7gebannt§8.",true);
                for(ProxiedPlayer all:BungeeCord.getInstance().getPlayers()) {
                    if(all.hasPermission("zyneon.team.ipban")||all.hasPermission("zyneon.team.banip")) {
                        if(all.getName()!=name) {
                            API.sendMessage(all,"§7Die IP §e"+a+"§7 wurde von §a"+name+"§7 für §c"+r+"§7gebannt§8!",true);
                        }
                    }
                }
                if(name!="der Konsole") {
                    API.sendMessage("§7Die IP §e"+a+"§7 wurde von §a"+name+"§7 für §c"+r+"§7gebannt§8!",true);
                }
            }
        } else {
            API.sendErrorMessage(s,API.noPerms);
        }
    }
}