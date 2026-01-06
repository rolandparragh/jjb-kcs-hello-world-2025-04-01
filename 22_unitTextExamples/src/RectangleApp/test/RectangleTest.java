package RectangleApp.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import RectangleApp.main.RectangleCalculate;
import divideApp.Divide;



public class RectangleTest {
	
	
	
	
	
	@Test
	public void testCalculateRectanglePerimeter() {
		
		RectangleCalculate rectangleCalculate = new RectangleCalculate();
		int actual = rectangleCalculate.getPerimeter(2,3);
		int expected = 10;
		
		Assert.assertEquals(expected, actual);
		 //import junit.framework.Assert; ---> ne innen
		
	}
	
	
	@Test
	public void testCalculateRectangleArea() {
		RectangleCalculate rectangleCalculate = new RectangleCalculate();
		int actual = rectangleCalculate.getArea(2,3);
		int expected = 6;
		
		Assert.assertEquals(expected, actual);
		
		
		
	}
	
	
	
	
	

}
