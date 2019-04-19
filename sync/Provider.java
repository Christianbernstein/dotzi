package de.christianbernstein;

import de.christianbernstein.network.NetworkProvider;

public class Provider {

    private Provider(){
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args){
        NetworkProvider provider = new NetworkProvider();
        provider.init(9000);
        provider.boot();
    }
}
