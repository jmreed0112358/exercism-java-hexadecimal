package hexadecimal;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

public class HexadecimalTest {
	
	private char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	
	@Test
	public void test_isGreaterThan_ValidInputs_IsGreaterThan_ExpectTrue() {
		assertEquals( Hexadecimal.isGreaterThan( "fff", "fef" ), true);
	}
	
	@Test
	public void test_isGreaterThan_ValidInputs_IsLessThan_ExpectFalse() {
		assertEquals( Hexadecimal.isGreaterThan( "fef", "fff" ), false);
	}
	
	@Test
	public void test_isGreaterThan_ValidInputs_IsEqual_ExpectFalse() {
		assertEquals( Hexadecimal.isGreaterThan( "fef", "fef" ), false);
	}
	
	@Test
	public void test_hexDigitToInt_ValidInputs_ExpectValidOutput() {
		int actual = 0;
		for (int i = 0 ; i < hexDigits.length ; i++ ) {
			actual = Hexadecimal.hexDigitToInt( hexDigits[i] );
			assertEquals(actual, i); // i happens to be the expected output.
		}
	}
	
	@Test
	public void test_hexDigitToInt_InvalidInputs_ThrowsException() {
		try {
			Hexadecimal.hexDigitToInt( 'z' );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Should have caught InvalidParameterException");
		}
	}
	
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

    /* Original test returned 0 on invalid input.
     * This makes no sense, since 0 is a valid return value for the input "00000"!
     * Changed to expect InvalidParameterException to be thrown on invalid inputs.
     */
    @Test
    public void testInvalid(){
    	try {
    		Hexadecimal.toDecimal( "carrot" );
    		fail("Expected to catch InvalidParameterException");
    	} catch ( InvalidParameterException ipe ) {
    		
    	} catch ( Exception e ) {
    		fail("Should have caught InvalidParameterException");
    	}
    	// Original test code.
        // int expected = 0;
        // assertEquals(expected, Hexadecimal.toDecimal("carrot"));
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
