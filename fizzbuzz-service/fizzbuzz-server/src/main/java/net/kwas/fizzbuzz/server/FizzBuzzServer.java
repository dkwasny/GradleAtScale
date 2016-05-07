package net.kwas.fizzbuzz.server;

import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FizzBuzzServer {

	private final int port;
	private final FizzProvider fizzProvider;
	private final BuzzProvider buzzProvider;

	public FizzBuzzServer(int port, FizzProvider fizzProvider, BuzzProvider buzzProvider) {
		this.port = port;
		this.fizzProvider = fizzProvider;
		this.buzzProvider = buzzProvider;
	}

	public void run() throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			System.out.println("Waiting for input on port " + port);
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			int input = dataInputStream.readInt();

			String response = generateOutput(input);

			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF(response);
		}
	}

	private String generateOutput(int iterations) {
		StringBuilder builder = new StringBuilder();

		for (int i = 1; i <= iterations; ++i) {
			builder.append(generateLine(i)).append("\n");
		}

		return builder.toString();
	}

	private String generateLine(int iteration) {
		String fizzBuzzOutput = fizzProvider.getFizz(iteration) + buzzProvider.getBuzz(iteration);

		String retVal;
		if ("".equals(fizzBuzzOutput)) {
			retVal = Integer.toString(iteration);
		}
		else {
			retVal = fizzBuzzOutput;
		}
		return retVal;
	}

}
