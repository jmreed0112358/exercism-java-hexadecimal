package hexadecimal;

import java.security.InvalidParameterException;

public class Hexadecimal
{
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
