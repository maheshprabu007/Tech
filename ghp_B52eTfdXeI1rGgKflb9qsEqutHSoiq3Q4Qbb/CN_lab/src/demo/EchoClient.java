package demo;

import java.io.*;
import java.util.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 4007);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		System.out.println("enter the string to server:");
		DataInputStream data = new DataInputStream(System.in);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		String string;
		while((string=data.readLine())!=null) {
			output.writeBytes(string);
			output.writeBytes("\n");
			System.out.println("\n message from server");
			System.out.println(input.readLine());
			System.out.println("enter your message");
		}
		System.exit(0);
		input.close();
		socket.close();
	    data.close();
	}

}
