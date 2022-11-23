package demo;

import java.net.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(4000);
		System.out.println("server is watiting for client");
		Socket socket = server.accept();
		System.out.println("client connected:");
		InputStream in = socket.getInputStream();
		DataInputStream data = new DataInputStream(in);
		int len = data.readInt();
		System.out.println(len);
		byte[] bytes = new byte[len];
		data.readFully(bytes);
		data.close();
		in.close();
		InputStream ian = new ByteArrayInputStream(bytes);
		BufferedImage bimage = ImageIO.read(ian);
		JFrame f = new JFrame("Server");
		ImageIcon icon = new ImageIcon(bimage);
		JLabel l = new JLabel();
		l.setIcon(icon);
		f.add(l);
		f.setVisible(true);
	}

}
