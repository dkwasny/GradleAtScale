package net.kwas.fizzbuzz.service.server;

import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;
import net.kwas.fizzbuzz.FizzBuzzProvider;

import java.io.IOException;

public class FizzBuzzServerDriver {

	public static void main(String[] args) throws IOException {
		int port = Integer.parseInt(args[0]);
		FizzBuzzProvider fizzBuzzProvider = new FizzBuzzProvider();
		FizzBuzzServer server = new FizzBuzzServer(port, fizzBuzzProvider);
		server.start();
	}

}
