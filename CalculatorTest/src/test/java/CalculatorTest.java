import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.CalculatorTest.Calculator;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	public void multiplyTest() {

		assertEquals(15, calculator.multiply(4, 5));

	}

	@Test
	public void divideTest() {
		assertEquals(2, calculator.divide(4, 2));
	}

}