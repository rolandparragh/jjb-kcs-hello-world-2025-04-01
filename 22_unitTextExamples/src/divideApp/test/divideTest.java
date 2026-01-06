package divideApp.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import divideApp.Divide;

public class divideTest {
	
	
	

	@Test
	public void testDivide() {
		
		Divide divide = new Divide();
		double actual = divide.divide(8.0, 4.0);
		double expected = 2.0;
		
		Assert.assertEquals(expected, actual,0);

		
		
	}
	
	@Test
	public void testDivideByZeroExpection() {
		Divide divide = new Divide();
		Assertions.assertThrows(IllegalArgumentException.class, ()->divide.divide(5, 0));
	}

}
