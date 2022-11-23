package demo;

import java.io.*;
import java.net.*;

public class EchoServer {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(4007);
		System.out.println("server is waiting for client");
		Socket socket = server.accept();
		System.out.println("server connected:");
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		boolean i = true;
		while(i) {
			System.out.println("message from client");
			String str = input.readLine();
			System.out.println(str);
			output.writeBytes(str);
			output.writeBytes("\n");
			i = false;
		}
	}

}
