package net.kwas.fizzbuzz.service.server;

import net.kwas.fizzbuzz.FizzBuzzProvider;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FizzBuzzServer {

	private final int port;
	private final FizzBuzzProvider fizzBuzzProvider;

	public FizzBuzzServer(int port, FizzBuzzProvider fizzBuzzProvider) {
		this.port = port;
		this.fizzBuzzProvider = fizzBuzzProvider;
	}

	public void start() throws IOException {
		System.out.println("Starting server");
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			runMainLoop(serverSocket);
		}
		System.out.println("Exiting server");
	}

	private void runMainLoop(ServerSocket serverSocket) throws IOException {
		while (true) {
			System.out.println("Waiting for input on port " + port);
			try (
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				DataInputStream dataInputStream = new DataInputStream(inputStream);
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream)
			) {
				int input = dataInputStream.readInt();
				if (input == -1) {
					System.out.println("Exit code found...");
					return;
				}
				dataOutputStream.writeUTF(generateOutput(input));
			}
		}
	}

	private String generateOutput(int iterations) {
		StringBuilder builder = new StringBuilder();

		for (int i = 1; i <= iterations; ++i) {
			builder.append(fizzBuzzProvider.getFizzBuzz(i)).append("\n");
		}

		return builder.toString();
	}

}
