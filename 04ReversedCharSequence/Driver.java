public class Driver {

    public static void main ( String[]args ) {
	ReversedCharSequence A = new ReversedCharSequence ( "catfish" );
	System.out.println ( A.charAt( 2 ) );
	System.out.println ( A.length( ) );
	System.out.println ( A.subSequence( 2 , 4 ) );
	System.out.println ( A.toString( ) );
    }
    
}
