package demo;

import java.net.*;
import java.io.*;

public class UdpdServer {

	private static int indexOf(String arr[], String string) {
		string = string.trim();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(string)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		String[] hosts = {"yahoo.com", "gmail.com","cricinfo.com", "facebook.com"}; 
		String[] ip = {"68.180.206.184", "209.85.148.19","80.168.92.140", "69.63.189.16"}; 
		System.out.println("press Ctrl + c quit");
		while(true) {
			DatagramSocket socket = new DatagramSocket(2034);
			byte[] senddata = new byte[1024];
			byte[] receivedata = new byte[1024];
			DatagramPacket packet = new DatagramPacket(receivedata, receivedata.length);
			socket.receive(packet);
			String string = new String(packet.getData());
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			String capsent;
			System.out.println("request for host" + string);
			if(indexOf(hosts, string) != -1) {
				capsent=ip[indexOf(hosts, string)];
			}
			else {
				capsent = "host not found";
			}
			senddata = capsent.getBytes();
			DatagramPacket sentpacket = new DatagramPacket(senddata, senddata.length, address, port);
			socket.send(packet);
			socket.close();
		}

	}

}
