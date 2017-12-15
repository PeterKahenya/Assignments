/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class ReceiverOne {
    public static void main(String[] args){
        try {
             
           Socket server=new Socket("127.0.0.1",1771);
           ServerSocket ssocket=new ServerSocket(1773);
           Socket receiver2=ssocket.accept();
           
           int messageCount=0;
           while(server!=null&receiver2!=null){
              DataInputStream s_is=new DataInputStream(server.getInputStream());
              DataInputStream r2_is=new DataInputStream(receiver2.getInputStream());
              DataOutputStream r2_os=new DataOutputStream(receiver2.getOutputStream());
              
              do{
                  
              }while(s_is.available()<=0);
              boolean message=s_is.readBoolean();
              messageCount++;
              long mytime=System.currentTimeMillis();
              r2_os.writeLong(mytime);
             long r2_time=r2_is.readLong();
             
             System.out.println( mytime+"ms - Average Offset= "+((mytime-r2_time)/messageCount));
           }
           
           
           
           
        } catch (IOException ex) {
            Logger.getLogger(ReceiverTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
