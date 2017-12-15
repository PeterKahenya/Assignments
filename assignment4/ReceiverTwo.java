package assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiverTwo {
    public static void main(String[] args){
        try {
            
            
            
            Socket receiver1=new Socket("127.0.0.1",1773);
            Socket server=new Socket("127.0.0.1",1772);
            
            int messageCount=0;
           while(server!=null&receiver1!=null){
              DataInputStream s_is=new DataInputStream(server.getInputStream());
              DataInputStream r1_is=new DataInputStream(receiver1.getInputStream());
              DataOutputStream r1_os=new DataOutputStream(receiver1.getOutputStream());
              
              do{
              }while(s_is.available()<=0);
              
              boolean message=s_is.readBoolean();
              messageCount++;
              long mytime=System.currentTimeMillis();
              r1_os.writeLong(mytime);
             long r1_time=r1_is.readLong();
             
             System.out.println(mytime+"ms - Average Offset= "+((mytime-r1_time)/messageCount)+" ms");
           }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ReceiverTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
