public class Barcode {
	private String[] values = { "||:::" , ":::||" , "::|:|" , "::||:" , ":|::|" ,
								":|:|:" , ":||::" , "|:::|" , "|::|:" , "|:|::" };   
	private char[] barcode;

	public Barcode ( int zip ) {
		String zip_ = Integer.toString( zip );
		char[] barcode_ = new char[ zip_.length( ) ];
		for ( int i = 0 ; i < zip_.length( ) ; i++ ) {
			barcode_[i] = zip_.charAt( i );
		}
		barcode = barcode_;
	} 

	public String toString ( ) {
		return getBar( ) + " (" + getZip( ) + ")";
	}

	public String stringify ( char[] arr ) {
		String output = "";
		for ( char num : arr ) {
			output = output + num;
		}
		return output;
	}

	public String getZip ( ) {
		return stringify ( barcode );
	}

	public String getBar ( ) {
		String output = "";
		int check = 0;
		for ( char num : barcode ) {
			output = output + values[ num - 48 ];
			check += num - 48;
		}
		output = output + values[ check % 10 ];
		return "|" + output + "|";
	}

	public boolean equals ( Barcode other ) {
		return barcode.equals( other.barcode );
	}

}