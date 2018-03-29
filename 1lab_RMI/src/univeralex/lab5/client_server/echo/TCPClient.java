package univeralex.lab5.client_server.echo;

import java.net.*;
import java.io.*;
public class TCPClient {
    public static void main (String arg[]) {
        Socket s = null;
        try {   System.out.println("Клиент запущен");
            int serverPort = 7896; String args[]=new String[2];  args[0]="Cake is a lie."; args[1]="127.0.0.1";
            s = new Socket(args[1], serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out =new DataOutputStream( s.getOutputStream());
            out.writeUTF(args[0]); // UTF is a string encoding
            String data = in.readUTF(); // read a line of data from the stream
            System.out.println("Received: "+ data) ;
        } catch (UnknownHostException e) {System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {System.out.println("EOF:" +e.getMessage());
        } catch (IOException e) {System.out.println("readline:" +e.getMessage());
// error in reading the stream
        } finally {
            if(s!=null) try {s.close();} catch (IOException e)   {System.out.println("close:" + e.getMessage());}}
    }
}