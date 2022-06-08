package live.nerotv.bungeebase.commands;

import live.nerotv.bungeebase.api.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class BungeeBase extends Command {

    public BungeeBase() {
        super("BungeeBase",null,"author","autor","plugin","dev","developer");
    }

    @Override
    public void execute(CommandSender s, String[] args) {
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9ProjectsBase4§7,"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9BungeeBase§7,"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9Lobbysystem v3§7,"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9KnockIT§7 und"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9SkyBlock Beta"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0  §7coded by §cnerotvlive§8."));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§f-> §9§nhttps://nerotv.live"));
        s.sendMessage(API.getBaseComponent(API.Prefix+"§0"));
        API.sendMessage(s,"§0");
    }
}
