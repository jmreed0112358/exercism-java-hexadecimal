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
		
		int result = 0;
		return result;
	}
}
