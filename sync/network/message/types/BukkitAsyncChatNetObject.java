package de.christianbernstein.network.message.types;

import de.christianbernstein.network.message.NetObject;
import de.christianbernstein.network.message.NetObjectType;

public class BukkitAsyncChatNetObject extends NetObject {

    private final String param;

    public BukkitAsyncChatNetObject(String paramSting){
        this.setType(NetObjectType.BUKKIT_ASYNC_CHAT_EVENT);
        param = paramSting;
    }

    public String getParam() {
        return param;
    }

}
