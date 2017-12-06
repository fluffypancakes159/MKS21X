import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
	private String[] values = { "||:::" , ":::||" , "::|:|" , "::||:" , ":|::|" ,
								":|:|:" , ":||::" , "|:::|" , "|::|:" , "|:|::" };   
	// private char[] barcode;
	private String zip;

	/* public Barcode ( int zip ) {
		String zip_ = Integer.toString( zip );
		for ( int i = zip_.length ; i < 5 ; i++ ) {
			zip_ = "0" + zip_;
		}
		char[] barcode_ = new char[ zip_.length( ) ];
		for ( int i = 0 ; i < zip_.length( ) ; i++ ) {
			char currentChar = zip_.charAt ( i );
			if ( currentChar < 48 || currentChar > 58 ) {
				throw new IllegalArgumentException ( );
			}	
			else {
				barcode_[i] = zip_.charAt( i );
			}
		}
		barcode = barcode_;
	} */

	// helper function

	public static String reversify ( String str ) {
		String str_ = "";
		for ( int i = str.length( ) - 1 ; i > 0 ; i-- ) {
			str_ = str_ + str.charAt( i );
		}
		return str_;
	}

	// actual functions

	public Barcode ( String zip ) {
		try {
			int zipTest = Integer.parseInt( zip );
		}
		catch ( NumberFormatException e ) { //         if the zip doesn't successfully parseInt (not a number)
			throw new IllegalArgumentException ( ); // throw an error
		}
		this.zip = zip;
	}

	public String toString ( ) {
		return getBar( ) + " (" + getZip( ) + ")";
	}

	public int compareTo ( Barcode other ) {
		String zip_ = reversify ( zip );
		String otherZip = reversify ( other.zip );
		return zip_.compareTo( otherZip );
	}

	public String getZip ( ) {
		return zip;
	}

	public String getBar ( ) {
		/* String output = "";
		int check = 0;
		for ( char num : barcode ) {
			output = output + values[ num - 48 ];
			check += num - 48;
		}
		output = output + values[ check % 10 ];
		return "|" + output + "|"; */
		return toBar ( );
	}

	public static String toZip ( String code ) {
		String[] values = { "||:::" , ":::||" , "::|:|" , "::||:" , ":|::|" ,
							":|:|:" , ":||::" , "|:::|" , "|::|:" , "|:|::" };
		if ( code.length( ) != 32 || 
			 code.charAt( 0 ) != '|' ||
			 code.charAt( 31 ) != '|' ) { // invalid barcode size and/or no bars at the start/end
			throw new IllegalArgumentException ( );
		}
		else {
			int check = 0;
			String zip = "";
			String code_ = code.substring( 1 , 31 );
			for ( int i = 0 ; i < code_.length( ) ; i += 5 ) {
				String currentBarValue = code_.substring( i , i + 5 );
				int currentNumValue = -1;
				for ( int j = 0 ; j < values.length ; j++ ) {
					if ( values[j].equals( currentBarValue ) ) {
						currentNumValue = j;
					}
				}
				if ( currentNumValue < 0 ) { // invalid barcode values
					throw new IllegalArgumentException ( );
				}
				else {
					zip = currentNumValue + zip;
					check += currentNumValue;
				}
			}
			if ( zip.charAt( 5 ) - 48 != check % 10 ) { // check num doesn't match the barcode
				throw new IllegalArgumentException ( );
			}
			else {
				return zip;
			}
		}
	}

	public String toBar ( ) {
		String output = "";
		int check = 0;
		for ( int i = 0 ; i < zip.length( ) ; i++ ) {
			int charValue = zip.charAt( i ) - 48;
			output = output + values[charValue];
			check += charValue;
		}
		output = output + values[check % 10];
		return "|" + output + "|";
	}

	public boolean equals ( Barcode other ) {
		return zip.equals( other.zip );
	}

}