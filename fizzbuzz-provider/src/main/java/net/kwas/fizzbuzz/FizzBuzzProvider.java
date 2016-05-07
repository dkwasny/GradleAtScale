package net.kwas.fizzbuzz;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;

public class FizzBuzzProvider {

	private static final LoadingCache<Integer, String> CACHE = CacheBuilder
		.newBuilder()
		.concurrencyLevel(4)
		.maximumSize(1000)
		.build(
			new FizzBuzzCacheLoader(
				new FizzProvider(),
				new BuzzProvider()
			)
		);

	public String getFizzBuzz(int iteration) {
		return CACHE.getUnchecked(iteration);
	}

}
