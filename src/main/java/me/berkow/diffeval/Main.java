package me.berkow.diffeval;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Main {

    public static void main(String[] args) {
        String hostAddress = "127.0.0.1";
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            hostAddress = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DEBackendMain.main(new String[]{hostAddress, "2552"});
        DEBackendMain.main(new String[]{hostAddress, "2553"});

        DEFrontendMain.main(new String[]{"-port", "2551"});
    }
}
