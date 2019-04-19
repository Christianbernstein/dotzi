package de.christianbernstein.network;

public class KryoChannel {

    private final int CLUSTER_ID;

    public KryoChannel(int clusterID){
        CLUSTER_ID = clusterID;
    }

    public int getId() {
        return CLUSTER_ID;
    }
}
