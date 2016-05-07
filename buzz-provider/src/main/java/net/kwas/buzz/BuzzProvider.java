package net.kwas.buzz;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class BuzzProvider {

	private static final LoadingCache<Integer, String> CACHE = CacheBuilder
		.newBuilder()
		.concurrencyLevel(4)
		.maximumSize(1000)
		.build(
			new CacheLoader<Integer, String>() {
				@Override
				public String load(Integer key) throws Exception {
					return key % 5 == 0 ? "Buzz" : "";
				}
			}
		);

	public String getBuzz(int iteration) {
		return CACHE.getUnchecked(iteration);
	}

}
