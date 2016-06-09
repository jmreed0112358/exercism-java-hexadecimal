package hexadecimal;

import java.security.InvalidParameterException;

public class Hexadecimal
{
	private static final String INT_MAX_HEX = "7FFFFFFF";
	
	public static int toDecimal(String hex) throws NullPointerException, InvalidParameterException {
		if ( hex == null ) {
			throw new NullPointerException();
		}
		if ( hex.isEmpty( ) ) {
			throw new InvalidParameterException();
		}
		// reverse string.
		String hexReversed = new StringBuilder(hex).reverse( ).toString( );
		int result = 0;
		// for each char:
		for (int i = 0 ; i < hexReversed.length( ) ; i++ ) {
			result += hexDigitToInt(hexReversed.charAt( i ) ) * Math.pow( 16, i );
		}
			// result += hexDigitToInt(char) * pow(16, i)
		return result;
	}
	
	public static boolean isGreaterThan( String first, String second ) throws InvalidParameterException {
		if ( first.isEmpty( ) || second.isEmpty( ) ) {
			throw new InvalidParameterException();
		} else if ( first.length( ) != second.length( ) ) {
			return ( first.length( ) > second.length( ) );
		} else if ( first.equals( second ) ) {
			return false;
		}
		
		for ( int i = 0 ; i < first.length( ) ; i++ ) {
			if (hexDigitToInt(first.charAt( i )) > hexDigitToInt(second.charAt( i ))) {
				return true;
			} else if (hexDigitToInt(first.charAt( i )) < hexDigitToInt(second.charAt( i ))) {
				return false;
			}
		}
		
		return false;
	}
	
	public static boolean isValidHexadecimalString(String input) {
		return false;
	}
	
	public static int hexDigitToInt(char hexDigit) throws InvalidParameterException {
		switch ( hexDigit ) {
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'a':
				return 10;
			case 'b':
				return 11;
			case 'c':
				return 12;
			case 'd':
				return 13;
			case 'e':
				return 14;
			case 'f':
				return 15;
			default:
				throw new InvalidParameterException();
		}
	}
}
