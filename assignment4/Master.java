/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class Master {
    public static void main(String[]args){
        try {
            ServerSocket ss1=new ServerSocket(1771);
            Socket socket1=ss1.accept();
            ServerSocket ss2=new ServerSocket(1772);
            Socket socket2=ss2.accept();
            
            
            while(socket1!=null&& socket2!=null){
                DataOutputStream dos1=new DataOutputStream(socket1.getOutputStream());
                DataOutputStream dos2=new DataOutputStream(socket2.getOutputStream());
                
                for(int x=0;x<5;x++){
                    dos1.writeBoolean(true);
                    dos2.writeBoolean(true);
                    Thread.sleep(500);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ReceiverTwo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReceiverTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
