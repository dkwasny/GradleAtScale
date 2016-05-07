package net.kwas.fizzbuzz;

import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;

public class FizzBuzzProvider {

	private final FizzProvider fizzProvider;
	private final BuzzProvider buzzProvider;

	public FizzBuzzProvider(FizzProvider fizzProvider, BuzzProvider buzzProvider) {
		this.fizzProvider = fizzProvider;
		this.buzzProvider = buzzProvider;
	}

	public String getFizzBuzz(int iteration) {
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
