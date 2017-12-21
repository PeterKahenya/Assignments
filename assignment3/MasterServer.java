/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MasterServer {

    public static void main(String[] args) {
        try {
           
            ServerSocket ss=new ServerSocket(1771);
            Socket s=ss.accept();
            while(s!=null){
                DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                DataInputStream dis=new DataInputStream(s.getInputStream());
                
                boolean request=false;
                if(dis.available()>0){
                    request=dis.readBoolean();
                    if(request){
                        System.out.println("Client sent request");
                        dos.writeLong(System.currentTimeMillis());
                    }
                }
            }
                } catch (IOException ex) {
            Logger.getLogger(MasterServer.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
