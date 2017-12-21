/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        try {
            Socket soc = new Socket("127.0.0.1", 1771);
            if (soc != null) {
                Scanner ss = new Scanner(System.in);
                int req = 1;
                while (true) {
                    System.out.println("Connected to time server, Enter Command\n 1. Get Server Time\n 2. exit");
                    req = ss.nextInt();
                    if (req == 1) {
                        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                        DataInputStream dis = new DataInputStream(soc.getInputStream());
                        
                        
                        //Cristians algorithm part
                        dos.writeBoolean(true);
                        long mytime=System.currentTimeMillis();
                        System.out.println("Sending request at :"+mytime +"ms");
                        
                        
                        long servertime=dis.readLong();
                        long recvtime=System.currentTimeMillis();
                        System.out.println("Server time "+servertime+" Received at "+recvtime+" Correct time="+(servertime-(recvtime-mytime)/2));
                        
                        
                    } else {
                        System.out.println("Disconnecting...");
                        soc.close();
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
