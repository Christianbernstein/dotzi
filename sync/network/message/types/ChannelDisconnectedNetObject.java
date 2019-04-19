package de.christianbernstein.network.message.types;

import com.esotericsoftware.kryonet.Connection;
import de.christianbernstein.network.message.NetObject;
import de.christianbernstein.network.message.NetObjectType;

public class ChannelDisconnectedNetObject extends NetObject {

    private final String param;
    private Connection con;

    public ChannelDisconnectedNetObject(String paramSting, Connection con){
        this.setType(NetObjectType.CHANNEL_DISCONNECT_EVENT);
        param = paramSting;
        this.con = con;
    }

    public String getParam() {
        return param;
    }

    public Connection getCon() {
        return con;
    }
}
