package live.nerotv.bungeebase.utils;

import java.util.UUID;

public class ZyneonPlayer {

    private int init;
    private UUID uuid;

    public ZyneonPlayer(UUID uuid) {
        init = 0;
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

    public int getInit() {
        return this.init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public void destroy() {
        init = -1;
        uuid = null;
        System.gc();
    }
}
