package demo;

import java.io.*;
import java.net.*;

public class UdpdClient {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket data = new DatagramSocket();
		InetAddress address;
		if(args.length==0) {
			address = InetAddress.getLocalHost();
		}
		else {
			address = InetAddress.getByName(args[0]);
		}
		byte[] senddata = new byte[1024];
		byte[] receivedata = new byte[1024];
		System.out.println("enter the hose name");
		String hostname = br.readLine();
		senddata = hostname.getBytes();
		DatagramPacket pack = new DatagramPacket(senddata, senddata.length, address, 2034);
		data.send(pack);
		DatagramPacket receive = new DatagramPacket(receivedata, receivedata.length);
		data.receive(receive);
		String str = new String(receive.getData());
		System.out.println("ipaddress"+str);
	}

}
