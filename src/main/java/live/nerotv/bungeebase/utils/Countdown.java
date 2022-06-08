package live.nerotv.bungeebase.utils;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.scheduler.ScheduledTask;

import java.util.concurrent.TimeUnit;

public abstract class Countdown {

    private int time;
    ScheduledTask task = null;
    protected final Plugin plugin;

    public Countdown(int time, Plugin plugin) {
        this.time = time;
        this.plugin = plugin;
    }

    public abstract void count(int current);

    public final void start() {
        task = plugin.getProxy().getScheduler().schedule(plugin, () -> {
            count(time);
            if(time-- <= 0)plugin.getProxy().getScheduler().cancel(task);
        }, 0,1,TimeUnit.SECONDS);
    }
}