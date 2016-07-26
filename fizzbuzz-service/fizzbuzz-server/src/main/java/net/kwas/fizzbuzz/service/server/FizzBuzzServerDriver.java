package net.kwas.fizzbuzz.service.server;

import java.io.IOException;

import net.kwas.fizzbuzz.FizzBuzzProvider;

public class FizzBuzzServerDriver {

	public static void main(String[] args) throws IOException {
		int port = Integer.parseInt(args[0]);
		FizzBuzzProvider fizzBuzzProvider = new FizzBuzzProvider();
		FizzBuzzServer server = new FizzBuzzServer(port, fizzBuzzProvider);
		server.start();
	}

}
