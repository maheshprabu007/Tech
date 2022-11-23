package demo;


import java.net.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket soc;
		BufferedImage img = null;
		soc = new Socket("localhost", 4000);
		System.out.println("client is running:");
		try {
			System.out.println("reading image from disk:");
			img = ImageIO.read(new File("C://Users//admin//Pictures//pictures//arrival.png"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img, "jpg", baos);
			baos.flush();
			byte[] bytes = baos.toByteArray();
			OutputStream out = soc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeInt(bytes.length);
			dos.write(bytes, 0, bytes.length);
			System.out.println("image sent to server:");
			dos.close();
			out.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
