package demo;

import java.net.*;
import java.io.*;

public class PingServer {

	public static void main(String[] args) {
		try {
			String str;
			System.out.println("enter the ip addrees:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String ip = br.readLine();
			Runtime H = Runtime.getRuntime();
			Process p = H.exec(ip);
			InputStream in = p.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
			while((str = br1.readLine()) != null) {
				System.out.println(str);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
