package net.kwas.fizzbuzz.service.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FizzBuzzClient {

	private final InetAddress host;
	private final int port;

	public FizzBuzzClient(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}

	public String call(int iterations) throws IOException {
		try (
			Socket socket = new Socket(host, port);
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
		) {
			dataOutputStream.writeInt(iterations);
			return dataInputStream.readUTF();
		}
	}

}
