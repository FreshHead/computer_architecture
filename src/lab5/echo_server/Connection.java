package lab5.echo_server;

import java.net.*;
import java.io.*;
class Connection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream( clientSocket.getInputStream());
            out = new DataOutputStream( clientSocket.getOutputStream());
            this.start();
        } catch(IOException e){System.out.println ("Connection:"+e.getMessage());
        }
    }
    public void run() { // an echo server
        try {
            String data = in.readUTF(); // read a line of data from the stream
            out.writeUTF("you send me: " + data); // write a line to the stream
            clientSocket.close();
        } catch (EOFException e){System.out.println ("EOF:"+e.getMessage());
        } catch (IOException e) {System.out.println ("readline:"+e.getMessage());}
    }
}