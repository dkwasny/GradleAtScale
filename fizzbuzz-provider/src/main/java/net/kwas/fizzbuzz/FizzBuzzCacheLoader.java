package net.kwas.fizzbuzz;

import com.google.common.cache.CacheLoader;
import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;

public class FizzBuzzCacheLoader extends CacheLoader<Integer, String> {

	private final FizzProvider fizzProvider;
	private final BuzzProvider buzzProvider;

	public FizzBuzzCacheLoader(FizzProvider fizzProvider, BuzzProvider buzzProvider) {
		this.fizzProvider = fizzProvider;
		this.buzzProvider = buzzProvider;
	}

	@Override
	public String load(Integer key) throws Exception {
		String fizzBuzzOutput = fizzProvider.getFizz(key) + buzzProvider.getBuzz(key);

		String retVal;
		if ("".equals(fizzBuzzOutput)) {
			retVal = key.toString();
		}
		else {
			retVal = fizzBuzzOutput;
		}
		return retVal;
	}
}
