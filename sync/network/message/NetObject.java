package de.christianbernstein.network.message;

public abstract class NetObject {

    private NetObjectType type;

    public NetObjectType getType() {
        return type;
    }

    public void setType(NetObjectType type) {
        this.type = type;
    }
}
