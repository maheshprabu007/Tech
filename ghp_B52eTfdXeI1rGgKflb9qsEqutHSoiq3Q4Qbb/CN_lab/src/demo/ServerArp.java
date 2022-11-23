package demo;

import java.net.*;
import java.io.*;

public class ServerArp {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(1001);
		System.out.println("server is waiting for client");
		Socket socket = server.accept();
		System.out.println("connected:");
		DataInputStream input  = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		String string = input.readLine();
		String ip[]={"165.165.80.80","165.165.79.1"}; 
		String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"}; 
		for(int i = 0; i < ip.length; i++) {
			if(ip[i].equals(string)) {
				output.writeBytes(mac[i]+'\n');
				break;
			}
		}
		socket.close();
	}

}
