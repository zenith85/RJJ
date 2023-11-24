/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibrah
 */
public class Reachability {
    public static boolean ping(String IP) throws IOException
    {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Reachability.class.getName()).log(Level.SEVERE, null, ex);
        }
            boolean reachable = address.isReachable(100);
            return reachable;
    }
    
}
