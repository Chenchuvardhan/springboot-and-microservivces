package in.cipla.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import in.cipla.calci.Calculator;

@SpringBootTest
public class CalculatorTest {
	@Test
	public void TestCalculatorAdd() {
    Calculator calculator = new Calculator();
    int i = calculator.add(10, 20);
    int j=30;
    Assertions.assertEquals(i,j);
	}
	@Test
	public void TestCalculatorMul() {
		Calculator calculator = new Calculator();
		int mul = calculator.mul(10, 2);
		int i=20;
		Assertions.assertEquals(i,mul);
	}
}
