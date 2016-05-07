package net.kwas.fizzbuzz.server;

import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;

import java.io.IOException;

public class FizzBuzzServerDriver {

	public static void main(String[] args) throws IOException {
		int port = Integer.parseInt(args[0]);
		FizzProvider fizzProvider = new FizzProvider();
		BuzzProvider buzzProvider = new BuzzProvider();
		FizzBuzzServer server = new FizzBuzzServer(port, fizzProvider, buzzProvider);
		server.run();
	}

}
