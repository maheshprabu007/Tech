package demo;


import java.net.*;
import java.io.*;

public class ClientArp {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Socket socket = new Socket("localhost", 1001);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		System.out.println("enter the logical address");
		String string = br.readLine();
		output.writeBytes(string+'\n');
		String string1 = input.readLine();
		System.out.println("physical address " + string1);
		socket.close();
	}

}
