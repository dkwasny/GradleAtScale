package net.kwas.fizz;

public class FizzProvider {

	public String getFizz(int iteration) {
		return iteration % 3 == 0 ? "Fizz" : "";
	}
}
