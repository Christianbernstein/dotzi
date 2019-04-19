package de.christianbernstein.mcutils.logger.types;

import java.util.Date;

public class Error {

    public static void send(String message){ //small errormessage
        System.out.println("[" + new Date().toLocaleString() + " ERROR] " + message);
    }

    public static void send(Exception e, String message){ //extendet errormassegt + logging
        System.out.println("------- [" + new Date().toLocaleString() + " | Exception ] -------");
        System.out.println();
        System.out.println("Exception : " + e.getClass());
        System.out.println("Message   : " + e.getMessage());
        System.out.println("Body      : " + e.getCause());
        System.out.println("Local msg : " + message);
        System.out.println();
        System.out.println("------- [" + new Date().toLocaleString() + " | Exception ] -------");

    }
}
