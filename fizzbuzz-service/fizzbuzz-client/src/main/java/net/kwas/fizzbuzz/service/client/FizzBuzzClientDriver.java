package net.kwas.fizzbuzz.service.client;

import java.io.IOException;
import java.net.InetAddress;

public class FizzBuzzClientDriver {

	public static void main(String[] args) throws IOException {
		int port = Integer.parseInt(args[0]);
		int iterations = Integer.parseInt(args[1]);
		InetAddress host = InetAddress.getLocalHost();
		FizzBuzzClient client = new FizzBuzzClient(host, port);
		System.out.println("Starting call...");
		String output = client.call(iterations);
		System.out.println("Output:");
		System.out.println(output);
		System.out.println("Done");
	}

}
