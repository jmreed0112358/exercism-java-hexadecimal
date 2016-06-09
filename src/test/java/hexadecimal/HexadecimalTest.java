package hexadecimal;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

public class HexadecimalTest {
	
	@Test
	public void test_toDecimal_NullString_ThrowsException() {
		try {
			Hexadecimal.toDecimal( null );
			fail("Expected to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Should have caught NullPointerException");
		}
	}
	
	@Test
	public void test_toDecimal_EmptyString_ThrowsException() {
		try {
			Hexadecimal.toDecimal( "" );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Should have caught InvalidParameterException.");
		}
	}
    @Test
    public void testOne(){
        int expected = 1;
        assertEquals(expected, Hexadecimal.toDecimal("1"));
    }

    @Test
    public void testC(){
        int expected = 12;
        assertEquals(expected, Hexadecimal.toDecimal("c"));
    }

    @Test
    public void test10(){
        int expected = 16;
        assertEquals(expected, Hexadecimal.toDecimal("10"));
    }

    @Test
    public void testAf(){
        int expected = 175;
        assertEquals(expected, Hexadecimal.toDecimal("af"));
    }

    @Test
    public void test100(){
        int expected = 256;
        assertEquals(expected, Hexadecimal.toDecimal("100"));
    }

    @Test
    public void test19ace(){
        int expected = 105166;
        assertEquals(expected, Hexadecimal.toDecimal("19ace"));
    }

    @Test
    public void testInvalid(){
        int expected = 0;
        assertEquals(expected, Hexadecimal.toDecimal("carrot"));
    }

    @Test
    public void testBlack(){
        int expected = 0;
        assertEquals(expected, Hexadecimal.toDecimal("000000"));
    }

    @Test
    public void testWhite(){
        int expected = 16777215;
        assertEquals(expected, Hexadecimal.toDecimal("ffffff"));
    }

    @Test
    public void testYellow(){
        int expected = 16776960;
        assertEquals(expected, Hexadecimal.toDecimal("ffff00"));
    }
}
