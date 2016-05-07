package net.kwas.fizzbuzz;

import net.kwas.buzz.BuzzProvider;
import net.kwas.fizz.FizzProvider;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzProviderTest {

	private final FizzBuzzProvider fizzBuzzProvider = new FizzBuzzProvider(
		new FizzProvider(),
		new BuzzProvider()
	);

	@Test
	public void getFizzBuzzNumberCase() {
		for (int i : new int[] {1, 2, 4, 7, 8, 11}) {
			String actual = fizzBuzzProvider.getFizzBuzz(i);
			Assert.assertEquals(Integer.toString(i), actual);
		}
	}

	@Test
	public void getFizzBuzzFizzCase() {
		for (int i : new int[] {3, 6, 9, 12, 18}) {
			String actual = fizzBuzzProvider.getFizzBuzz(i);
			Assert.assertEquals("Fizz", actual);
		}
	}

	@Test
	public void getFizzBuzzBuzzCase() {
		for (int i : new int[] {5, 10, 20}) {
			String actual = fizzBuzzProvider.getFizzBuzz(i);
			Assert.assertEquals("Buzz", actual);
		}
	}

	@Test
	public void getFizzBuzzFizzBuzzCase() {
		for (int i : new int[] {15, 30}) {
			String actual = fizzBuzzProvider.getFizzBuzz(i);
			Assert.assertEquals("FizzBuzz", actual);
		}
	}

}
