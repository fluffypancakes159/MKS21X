public class CharSequence {

    char[] chars;
    
    public CharSequence ( String str ) {
	chars = new char[ str.length( ) ];
	for ( int i = 0 ; i < str.length( ) ; i++ ) {
	    chars[i] = str.charAt ( str.length( ) - 1 - i );
	}
    }

    public char charAt ( int index ) {
	return chars[index];
    }

    public int length ( ) {
	return chars.length;
    }

    public CharSequence subSequence ( int start , int end ) {
	String output = "";
	for ( int i = start ; i < end ; i++ ) {
	    output = output + chars[i];
	}
	return new CharSequence ( output );  
    }

    public String toString ( ) {
	String output = "";
	for ( int i = 0 ; i < chars.length ; i++ ) {
	    output = output + chars[i];
	}
	return output;
    }
    
}
