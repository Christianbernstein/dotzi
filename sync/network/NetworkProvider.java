package de.christianbernstein.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import de.christianbernstein.network.message.NetObjectHandler;
import de.christianbernstein.network.message.types.ChannelConnectNetObject;
import de.christianbernstein.network.message.types.ChannelDisconnectedNetObject;
import de.christianbernstein.network.message.types.ProviderShutdownNetObject;

import java.io.IOException;

public class NetworkProvider {

    private final Server provider = new Server();

    public void init(int port){
        provider.start();
        try {
            provider.bind(port);
        }catch (IOException ex){
            //todo logger
        }
    }

    public void boot(){
        provider.addListener(new Listener(){

            @Override
            public void received(Connection connection, Object o) {
                provider.sendToAllTCP(o);
                //todo logger
            }

            @Override
            public void connected(Connection connection) {
                NetObjectHandler.sendSerializedNetMessage(provider, new ChannelConnectNetObject(
                        "New client connected and integrated into the service", connection));
                //todo logger
            }

            @Override
            public void disconnected(Connection connection) {
                NetObjectHandler.sendSerializedNetMessage(provider, new ChannelDisconnectedNetObject(
                        "Client disconnected from provider and can not be accessed anymore",  connection));
                //todo logger
            }
        });
    }

    public void shutdown(){
        NetObjectHandler.sendSerializedNetMessage(provider, new ProviderShutdownNetObject(
                "The provider is now shut down and the service can no longer be used"));
        //todo logger
    }
}
