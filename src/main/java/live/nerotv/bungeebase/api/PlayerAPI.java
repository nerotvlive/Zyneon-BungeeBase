package live.nerotv.bungeebase.api;

import live.nerotv.bungeebase.utils.Communicate;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PlayerAPI {

    public static void playNewSound(ProxiedPlayer player,NewSound newSound) {
        Communicate.sendSound(player,newSound.toString());
    }
}