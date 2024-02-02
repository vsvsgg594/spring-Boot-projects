package com.employee.management.system.com;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComApplicationTests {

	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void sumTest() {
		int expectedResult = 6;
		int actualResult = c.doSum(1, 2, 3);
		assertThat(actualResult).isEqualTo(expectedResult);

	}

	@Test
	void productTest() {
		int product = c.product(4, 7);
		int expected = 27;
		assertThat(product).isGreaterThan(expected);
	}

	@Test
	void name() {
		String str = "welcame";
		boolean str2 = c.name();
		assertThat(str2).isTrue();
	}

}
