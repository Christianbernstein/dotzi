package de.christianbernstein.horizon.shared.util;

import java.net.InetSocketAddress;
import java.net.ServerSocket;


public class PortValidator {

    public static boolean validate(int port){
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            serverSocket.close();
            return true;
        }catch (Exception ex){
            //todo log
            return false;
        }
    }

}
