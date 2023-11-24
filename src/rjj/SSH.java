/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rjj;
import java.util.Properties;
import com.jcraft.jsch.*;
import java.io.InputStream;
/**
 *
 * @author ibrah
 */
public class SSH {
    public static void sendcmd(String host, String cmd) 
    {
        //String host="192.168.219.192";
	String user="pi";
	String password="Engineer";
	    //String command1="sudo shutdown";
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
	        //((ChannelExec)channel).setCommand(command1);
                ((ChannelExec)channel).setCommand(cmd);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
        }

    }
}

