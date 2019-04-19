package de.christianbernstein.network;

import java.util.ArrayList;
import java.util.List;

public class ClusterHandler {

    private static List<KryoChannel> cluster = new ArrayList<KryoChannel>();


    public static void addConnection(){
        cluster.add(new KryoChannel(1));
    }

    public static void removConnection(int clusterID){
        for(KryoChannel channel : cluster){
            if(clusterID == channel.getId()){
                cluster.remove(channel);
                //todo change to smaller function...
            }
        }
    }

    public static List<KryoChannel> getCluster(){
        return cluster;
    }

}
