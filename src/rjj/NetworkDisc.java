/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import rjj.main;

/**
 *
 * @author ibrah
 */
public class NetworkDisc {
    public static String ping(String ClientName, String ipAddress) throws UnknownHostException, IOException 
  { 
        
        InetAddress geek = InetAddress.getByName(ipAddress);
        main.Error_field.setText("Sending Ping Request to " + ClientName);
        System.out.println("Sending Ping Request to " + main.Client_1_name);
        if (geek.isReachable(5000)) {
            main.Error_field.setText(ClientName+" is reachable");
            System.out.println(ClientName+" is reachable");
            return ("ok");
        } else {
            System.out.println("Sorry ! We can't reach to this host");
            main.Error_field.setText(ClientName+" is unreachable");
            return ("Not ok");
        }
    }
}
