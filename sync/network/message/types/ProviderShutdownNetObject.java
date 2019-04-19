package de.christianbernstein.network.message.types;

import de.christianbernstein.network.message.NetObject;
import de.christianbernstein.network.message.NetObjectType;

public class ProviderShutdownNetObject extends NetObject {

    private final String param;

    public ProviderShutdownNetObject(String paramSting){
        this.setType(NetObjectType.PROVIDER_SHUTDOWN);
        param = paramSting;
    }

    public String getParam() {
        return param;
    }
}
