package net.kwas.buzz;

import org.junit.Assert;
import org.junit.Test;

public class BuzzProviderTest {

	private final BuzzProvider buzzProvider = new BuzzProvider();

	@Test
	public void getBuzzNotDivisibleByFive() {
		for (int i : new int[] {1, 2, 3, 4, 6, 7, 8, 9}) {
			String actual = buzzProvider.getBuzz(i);
			Assert.assertEquals("", actual);
		}
	}

	@Test
	public void getBuzzDivisibleByFive() {
		for (int i : new int[] {5, 10}) {
			String actual = buzzProvider.getBuzz(i);
			Assert.assertEquals("Buzz", actual);
		}
	}

}
