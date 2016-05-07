package net.kwas.buzz;

public class BuzzProvider {

	public String getBuzz(int iteration) {
		return iteration % 5 == 0 ? "Buzz" : "";
	}

}
