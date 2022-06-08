package live.nerotv.bungeebase.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Receive implements Listener {

    @EventHandler
    public void onReceive(PluginMessageEvent e) {
        if ( !e.getTag().equalsIgnoreCase("base:spigot")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(e.getData());
        String subChannel = in.readUTF();
        if (subChannel.equalsIgnoreCase("bungee")) {
            if (e.getReceiver() instanceof ProxiedPlayer) {
                ProxiedPlayer receiver = (ProxiedPlayer) e.getReceiver();
            }
            if (e.getReceiver() instanceof Server) {
                Server receiver = (Server) e.getReceiver();
            }
        } else if(subChannel.equalsIgnoreCase("server_lobby")) {
            String data1 = in.readUTF();
            int data2 = in.readInt();
            if(BungeeCord.getInstance().getPlayer(data1)!=null) {
                ProxiedPlayer p = BungeeCord.getInstance().getPlayer(data1);
                if(!p.getServer().getInfo().getName().equalsIgnoreCase("Lobby-1")) {
                    p.connect(BungeeCord.getInstance().getServerInfo("Lobby-1"));
                }
            }
        } else if(subChannel.equalsIgnoreCase("server_project")) {
            String data1 = in.readUTF();
            int data2 = in.readInt();
            if(BungeeCord.getInstance().getPlayer(data1)!=null) {
                ProxiedPlayer p = BungeeCord.getInstance().getPlayer(data1);
                if(!p.getServer().getInfo().getName().equalsIgnoreCase("Projekt-1")) {
                    p.connect(BungeeCord.getInstance().getServerInfo("Projekt-1"));
                }
            }
        } else if(subChannel.equalsIgnoreCase("server_knockit")) {
            String data1 = in.readUTF();
            int data2 = in.readInt();
            if(BungeeCord.getInstance().getPlayer(data1)!=null) {
                ProxiedPlayer p = BungeeCord.getInstance().getPlayer(data1);
                if(!p.getServer().getInfo().getName().equalsIgnoreCase("KnockIT-1")) {
                    p.connect(BungeeCord.getInstance().getServerInfo("KnockIT-1"));
                }
            }
        }
    }
}