package net.kwas.fizz;

import org.junit.Assert;
import org.junit.Test;

public class FizzProviderTest {

	private final FizzProvider fizzProvider = new FizzProvider();

	@Test
	public void getFizzNotDivisibleByThree() {
		for (int i : new int[] {1, 2, 4, 5, 7, 8, 10}) {
			String actual = fizzProvider.getFizz(i);
			Assert.assertEquals("", actual);
		}
	}

	@Test
	public void getFizzDivisibleByThree() {
		for (int i : new int[] {3, 6, 9}) {
			String actual = fizzProvider.getFizz(i);
			Assert.assertEquals("Fizz", actual);
		}
	}

}
