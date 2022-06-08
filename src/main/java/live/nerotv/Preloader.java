package live.nerotv;

import live.nerotv.bungeebase.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Plugin;

public final class Preloader extends Plugin {

    private static Preloader instance;
    private static String version = "v";
    public static String getVersion() { if(version.equalsIgnoreCase("v")) {return "0";} else {return version;} }
    public static Preloader getInstance() { return instance; }

    @Override
    public void onLoad() {
        sendMessage("Loading BungeeBase preloader...");
        version = getDescription().getVersion();
        sendMessage("Loading BungeeBase...");
        Main.onLoad();
    }

    @Override
    public void onEnable() {
        sendMessage("Checking for plugin dependencies...");
        sendMessage("Enabling BungeeBase...");
        instance = this;
        Main.onEnable();
    }

    @Override
    public void onDisable() {
        sendMessage("Disabling BungeeBase plugin...");
        Main.onDisable();
        version = null;
        instance = null;
    }

    private static void sendMessage(String message) {
        BaseComponent msg = new ComponentBuilder("§7[BungeeBase] §e[PRELOADER] §7"+message).getCurrentComponent();
        BungeeCord.getInstance().getConsole().sendMessage(msg);
    }
}
